package sih.compta.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.compta.entities.Activite;
import sih.compta.repositories.ActiviteRepository;
import sih.securite.entities.Agir;
import sih.securite.entities.Utilisateur;
import sih.securite.repositories.AgirRepo;
import sih.securite.repositories.ObjetRepo;

@Service
public class ActiviteService {

	private final ActiviteRepository repo;
	@Autowired
	private ObjetRepo orepo; 
	private final AgirRepo aux;

	public ActiviteService(ActiviteRepository repo, ObjetRepo objr, AgirRepo aux) {
		super();
		this.repo = repo;
		this.aux = aux;
	}

	public List<Activite> getAll(){
		return repo.findAll();
	}
	
	public Activite select(Long id) {
		return repo.findById(id).get();
	}
	
	public Activite insert(Activite elt,Utilisateur us) {
		Activite nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("Activite").get());
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public Activite edit(Activite elt,Utilisateur us) {
		Activite ancien=repo.findById(elt.getIdAct()).get();
		Activite nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("Activite").get());
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		Activite ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setTable(orepo.findById("Activite").get());
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
		
}
