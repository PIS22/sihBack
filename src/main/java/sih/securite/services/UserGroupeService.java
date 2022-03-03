package sih.securite.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.securite.entities.Agir;
import sih.securite.entities.UserGroup;
import sih.securite.entities.Utilisateur;
import sih.securite.repositories.AgirRepo;
import sih.securite.repositories.ObjetRepo;
import sih.securite.repositories.UserGroupRepo;
@Service
public class UserGroupeService {
	private final UserGroupRepo repo;
	private final AgirRepo aux;
	@Autowired
	private ObjetRepo orepo;

	public UserGroupeService(UserGroupRepo repo, AgirRepo aux) {
		super();
		this.repo = repo;
		this.aux = aux;
	}

	public UserGroup insert(UserGroup elt,Utilisateur us) {
		UserGroup nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("UserGroup").get());
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public UserGroup edit(UserGroup elt,Utilisateur us) {
		UserGroup ancien=repo.findById(elt.getIdUsGpe()).get();
		UserGroup nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("UserGroup").get());
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		UserGroup ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setTable(orepo.findById("UserGroup").get());
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
	public List<UserGroup> list(){
		return repo.findAll();
	}
	
	public UserGroup select(Long id) {
		return repo.findById(id).get();
	}

}
