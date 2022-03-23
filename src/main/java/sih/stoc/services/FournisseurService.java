package sih.stoc.services;

import java.util.List;

import org.springframework.stereotype.Service;

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
		try {
			return repo.save(elt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
		// Modification
	public Fournisseur edit(String cod, Fournisseur elt) {
		Fournisseur ancien=repo.findById(cod).get();
		ancien.setCodFour(elt.getCodFour());
		ancien.setLibFour(elt.getLibFour());
		try {
			return repo.save(ancien);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public List<Fournisseur> list(){
		return repo.findAll();
	}
	
	public void delete(String cod) {
		try {
			repo.deleteById(cod);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Fournisseur select(String id) {
		return repo.findById(id).get();
	}
	
	
}