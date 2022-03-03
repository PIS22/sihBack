package sih.compta.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.compta.entities.CompteArticle;
import sih.compta.repositories.CompteArticleRepository;
import sih.securite.entities.Agir;
import sih.securite.entities.Utilisateur;
import sih.securite.repositories.AgirRepo;
import sih.securite.repositories.ObjetRepo;

@Service
public class CompteArticleService {

	@Autowired
	private ObjetRepo orepo;
	private final CompteArticleRepository repo;
	private final AgirRepo aux;
	
	public CompteArticleService(CompteArticleRepository repo, AgirRepo aux) {
		super();
		this.repo = repo;
		this.aux = aux;
	}

	public List<CompteArticle> getAll(){
		return repo.findAll();
	}

	public CompteArticle selectByID(Long id) {
		return repo.findById(id).get();
	}
	
	public CompteArticle insert(CompteArticle elt,Utilisateur us) {
		CompteArticle nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("CommuneArticle").get());
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public CompteArticle edit(CompteArticle elt,Utilisateur us) {
		CompteArticle ancien=repo.findById(elt.getIdComArt()).get();
		CompteArticle nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("CommuneArticle").get());
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		CompteArticle ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setTable(orepo.findById("CommuneArticle").get());
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
}
