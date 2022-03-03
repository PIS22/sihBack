package sih.general.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.general.entities.Commune;
import sih.general.repositories.CommuneRepo;
import sih.securite.entities.Agir;
import sih.securite.entities.Utilisateur;
import sih.securite.repositories.AgirRepo;
import sih.securite.repositories.ObjetRepo;


@Service
public class CommuneService {
	
	//Declaration
	@Autowired
	private ObjetRepo orepo;
	private final CommuneRepo repo;
	private final AgirRepo aux;
	
	//Initialization into the constructor
	public CommuneService(CommuneRepo repo, AgirRepo aux, ObjetRepo objr) {
		super();
		this.repo = repo;
		this.aux = aux;
	}

	// Insertion
	public Commune insert(Commune elt, Utilisateur us) {
		Commune nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("Commune").get());
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	//Modification
	
	public Commune edit(Commune elt,Utilisateur us) {
		Commune ancien=repo.findById(elt.getIdCom()).get();
		Commune nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("Commune").get());
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	
	}
	
	public void delete(Long id,Utilisateur us) {
		Commune ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setTable(orepo.findById("Commune").get());
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
	public List<Commune> list(){
		return repo.findAll();
	}
	
	public Commune select(Long id) {
		return repo.findById(id).get();
	}
	
}

