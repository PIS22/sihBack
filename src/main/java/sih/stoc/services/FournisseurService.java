package sih.stoc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sih.securite.entities.Utilisateur;
import sih.stoc.entities.Fournisseur;
import sih.stoc.repositories.FournisseurRepo;

@Service
public class FournisseurService {
	private final FournisseurRepo repo;
	
	public FournisseurService(FournisseurRepo repo) {
		super();
		this.repo = repo;
	}
	
	public Fournisseur insert(Fournisseur elt) {
		/*Fournisseur nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setTable(orepo.findById("Fournisseur").get());
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;*/
		try {
			return repo.save(elt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
		// Modification
	public Fournisseur edit(Fournisseur elt) {
		/*Fournisseur ancien=repo.findById(elt.getIdFour()).get();
		Fournisseur nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setTable(orepo.findById("Fournisseur").get());
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;*/
		try {
			return repo.save(elt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public void delete(Long id,Utilisateur us) {
		/*Fournisseur ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setTable(orepo.findById("Fournisseur").get());
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}*/
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<Fournisseur> list(){
		return repo.findAll();
	}
	
	public void delete(Fournisseur frs) {
		try {
			repo.delete(frs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Fournisseur select(String id) {
		return repo.findById(id).get();
	}
	
	
}