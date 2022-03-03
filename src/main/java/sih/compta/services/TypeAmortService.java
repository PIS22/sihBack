package sih.compta.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.compta.entities.TypeAmort;
import sih.compta.repositories.TypeAmortRepository;
import sih.securite.entities.Agir;
import sih.securite.entities.Utilisateur;
import sih.securite.repositories.AgirRepo;
import sih.securite.repositories.ObjetRepo;


@Service
public class TypeAmortService {

	@Autowired
	private ObjetRepo orepo;
	private final TypeAmortRepository repo;
	private final AgirRepo aux;
	
	public TypeAmortService(TypeAmortRepository repo, AgirRepo aux) {
		super();
		this.repo = repo;
		this.aux = aux;
	}

	public List<TypeAmort> getAll(){
		return repo.findAll();
	}
	
	public TypeAmort getById(Long id) {
		return repo.findById(id).get();
	}
	

	public TypeAmort insert(TypeAmort elt,Utilisateur us) {
		TypeAmort nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("TypeAmort").get());
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public TypeAmort edit(TypeAmort elt,Utilisateur us) {
		TypeAmort ancien=repo.findById(elt.getIdTypAmo()).get();
		TypeAmort nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("TypeAmort").get());
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		TypeAmort ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setTable(orepo.findById("TypeAmort").get());
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}

}
