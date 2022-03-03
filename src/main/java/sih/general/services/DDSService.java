package sih.general.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.general.entities.DDS;
import sih.general.repositories.DDSRepo;
import sih.securite.entities.Agir;
import sih.securite.entities.Utilisateur;
import sih.securite.repositories.AgirRepo;
import sih.securite.repositories.ObjetRepo;

@Service
public class DDSService {
	
	//Declaration
	private final DDSRepo repo;
	private final AgirRepo aux;
	@Autowired
	private ObjetRepo orepo;
	
	//Initialization into the constructor
	public DDSService(DDSRepo repo, AgirRepo aux) {
		super();
		this.repo = repo;
		this.aux = aux;
	}

	// Insertion
	public DDS insert(DDS elt, Utilisateur us) {
		DDS nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("DDS").get());
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	//Modification
	
	public DDS edit(DDS elt,Utilisateur us) {
		DDS ancien=repo.findById(elt.getIddds()).get();
		DDS nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("DDS").get());
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	
	}
	
	public void delete(Long id,Utilisateur us) {
		DDS ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setTable(orepo.findById("DDS").get());
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
	public List<DDS> list(){
		return repo.findAll();
	}
	
	public DDS select(Long id) {
		return repo.findById(id).get();
	}
	
}
