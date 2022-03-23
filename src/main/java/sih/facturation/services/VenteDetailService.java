package sih.facturation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.facturation.entities.VenteDetail;
import sih.facturation.repositories.VenteDetailRepo;
import sih.securite.entities.Utilisateur;


@Service
public class VenteDetailService {


	@Autowired
	private final VenteDetailRepo repo;
	
	
	public VenteDetailService(VenteDetailRepo repo) {
		super();
		this.repo = repo;
	}
	
	public VenteDetail insert(VenteDetail elt, Utilisateur us) {
		return repo.save(elt);
	}
		// Modification
	public VenteDetail edit(VenteDetail elt,Utilisateur us) {
		return repo.save(elt);
	}
	
	public void delete(Long id) {
			repo.deleteById(id);
	}
	
	public List<VenteDetail> list(){
		return repo.findAll();
	}
	
	public VenteDetail select(Long id) {
		return repo.findById(id).get();
	}
}
