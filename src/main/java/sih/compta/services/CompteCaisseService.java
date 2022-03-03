package sih.compta.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.compta.entities.CompteCaisse;
import sih.compta.repositories.CompteCaisseRepository;
import sih.securite.entities.Agir;
import sih.securite.entities.Utilisateur;
import sih.securite.repositories.AgirRepo;
import sih.securite.repositories.ObjetRepo;

@Service
public class CompteCaisseService {

	@Autowired
	private ObjetRepo orepo;
	private final CompteCaisseRepository repo;
	private final AgirRepo aux;
	
	public CompteCaisseService(CompteCaisseRepository repo,  AgirRepo aux) {
		super();
		this.repo = repo;
		this.aux = aux;
	}

	public List<CompteCaisse> getAll(){
		return repo.findAll();
	}
	
	public CompteCaisse getById(Long id) {
		return repo.findById(id).get();
	}
	
	public CompteCaisse insert(CompteCaisse elt,Utilisateur us) {
		CompteCaisse nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("CommuneCaisse").get());
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public CompteCaisse edit(CompteCaisse elt,Utilisateur us) {
		CompteCaisse ancien=repo.findById(elt.getIdComCas()).get();
		CompteCaisse nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("CommuneCaisse").get());
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		CompteCaisse ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setTable(orepo.findById("CommuneCaisse").get());
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
	
}
