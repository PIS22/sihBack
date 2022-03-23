package sih.facturation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.facturation.entities.ModePaiement;
import sih.facturation.repositories.ModePaiementRepository;

@Service
public class ModePaiementService {
	@Autowired
	private ModePaiementRepository repo;
	
	public ModePaiement insert(ModePaiement elt) {
		return repo.save(elt);
	}
	
	public ModePaiement edit(ModePaiement elt) {
		return repo.save(elt);
	}
	
	public void delete(String id) {
			repo.deleteById(id);
	}
	
	public ModePaiement select(String id){
		return repo.findById(id).get();
	}
	
	public List<ModePaiement> findByCode(String code){
		return repo.findByCodeModPay(code);
	}
	
	public List<ModePaiement> findByLibelle(String lib){
		return repo.findByLibeModPay(lib);
	}
	
	public List<ModePaiement> findAll(){
		return repo.findAll();
	}
}
