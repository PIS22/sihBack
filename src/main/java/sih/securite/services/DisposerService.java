package sih.securite.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.securite.entities.Agir;
import sih.securite.entities.Disposer;
import sih.securite.entities.Utilisateur;
import sih.securite.repositories.AgirRepo;
import sih.securite.repositories.DisposerRepo;
import sih.securite.repositories.ObjetRepo;

@Service
public class DisposerService {
	private final DisposerRepo repo;
	@Autowired
	private ObjetRepo orepo;
	private final AgirRepo aux;
	
	public DisposerService(DisposerRepo repo, AgirRepo aux, ObjetRepo objr) {
		//super();
		this.repo = repo;
		this.aux = aux;
	}

	public Disposer insert(Disposer elt,Utilisateur us) {
		Disposer nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.toString());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("Disposer").get());
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public Disposer edit(Disposer elt,Utilisateur us) {
		Disposer ancien=repo.findById(elt.getIdDis()).get();
		Disposer nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.toString());
			act.setNouvellesValeurs(nouveau.toString());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("Disposer").get());
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		Disposer ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.toString());
				act.setDatActe(LocalDateTime.now());
				act.setTable(orepo.findById("Disposer").get());
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
	public List<Disposer> list(){
		return repo.findAll();
	}
	
	public Disposer select(Long id) {
		return repo.findById(id).get();
	}

}
