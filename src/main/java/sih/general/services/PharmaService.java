package sih.general.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.general.entities.Pharmacie;
import sih.general.repositories.PharmaRepo;
import sih.securite.entities.Agir;
import sih.securite.entities.Utilisateur;
import sih.securite.repositories.AgirRepo;
import sih.securite.repositories.ObjetRepo;


@Service
public class PharmaService {

	//Declaration
	@Autowired
	private ObjetRepo orepo;
	private final PharmaRepo repo;
	private final AgirRepo aux;

//Initialization into the constructor
	public PharmaService(PharmaRepo repo, AgirRepo aux) {
		super();
		this.repo = repo;
		this.aux = aux;
	}
	
	// Insertion
	public Pharmacie insert(Pharmacie elt, Utilisateur us) {
		Pharmacie nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("Pharmacie").get());
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	//Modification
	
	public Pharmacie edit(Pharmacie elt,Utilisateur us) {
		Pharmacie ancien=repo.findById(elt.getIdPharma()).get();
		Pharmacie nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("Pharmacie").get());
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	
	}
	
	public void delete(Long id,Utilisateur us) {
		Pharmacie ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setTable(orepo.findById("Pharmacie").get());
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
	public List<Pharmacie> list(){
		return repo.findAll();
	}
	
	public Pharmacie select(Long id) {
		return repo.findById(id).get();
	}	
	
}
