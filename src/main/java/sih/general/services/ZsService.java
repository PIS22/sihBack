package sih.general.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.general.entities.ZoneSanitaire;
import sih.general.repositories.ZSRepo;
import sih.securite.entities.Agir;
import sih.securite.entities.Utilisateur;
import sih.securite.repositories.AgirRepo;
import sih.securite.repositories.ObjetRepo;

@Service
public class ZsService {
	
	private final ZSRepo repo;
	private final AgirRepo aux;
	@Autowired
	private ObjetRepo orepo;
	
	public ZsService(ZSRepo repo, AgirRepo aux) {
		super();
		this.repo = repo;
		this.aux = aux;
	}
	
	public ZoneSanitaire insert(ZoneSanitaire elt, Utilisateur us) {
		ZoneSanitaire nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("ZoneSanitaire").get());
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
		// Modification
	public ZoneSanitaire edit(ZoneSanitaire elt,Utilisateur us) {
		ZoneSanitaire ancien=repo.findById(elt.getIdZS()).get();
		ZoneSanitaire nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("ZoneSanitaire").get());
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		ZoneSanitaire ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setTable(orepo.findById("ZoneSanitaire").get());
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
	public List<ZoneSanitaire> list(){
		return repo.findAll();
	}
	
	public ZoneSanitaire select(Long id) {
		return repo.findById(id).get();
	}
	
	
}
	

