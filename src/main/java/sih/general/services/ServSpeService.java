package sih.general.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.general.entities.ServicesSpecialises;
import sih.general.repositories.ServSpeRepo;
import sih.securite.entities.Agir;
import sih.securite.entities.Utilisateur;
import sih.securite.repositories.AgirRepo;
import sih.securite.repositories.ObjetRepo;

@Service
public class ServSpeService {


	//Declaration
	private final ServSpeRepo repo;
	private final AgirRepo aux;
	@Autowired
	private ObjetRepo orepo;

//Initialization into the constructor
	public ServSpeService(ServSpeRepo repo, AgirRepo aux) {
		super();
		this.repo = repo;
		this.aux = aux;
	}
	
	// Insertion
	public ServicesSpecialises insert(ServicesSpecialises elt, Utilisateur us) {
		ServicesSpecialises nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("ServicesSpecialises").get());
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	
	//Modification
	
	public ServicesSpecialises edit(ServicesSpecialises elt,Utilisateur us) {
		ServicesSpecialises ancien=repo.findById(elt.getIdServS()).get();
		ServicesSpecialises nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("ServicesSpecialises").get());
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	
	}
	
	
	public void delete(Long id,Utilisateur us) {
		ServicesSpecialises ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setTable(orepo.findById("ServicesSpecialises").get());
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
	public List<ServicesSpecialises> list(){
		return repo.findAll();
	}
	
	public ServicesSpecialises select(Long id) {
		return repo.findById(id).get();
	}
}
