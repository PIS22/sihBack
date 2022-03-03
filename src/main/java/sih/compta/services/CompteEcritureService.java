package sih.compta.services;

import java.util.List;

import org.springframework.stereotype.Service;

import sih.compta.entities.CompteEcriture;
import sih.compta.repositories.CompteEcritureRepository;

@Service
public class CompteEcritureService {

	private final CompteEcritureRepository repo;

	public CompteEcritureService(CompteEcritureRepository repo) {
		super();
		this.repo = repo;
	}
	
	public List<CompteEcriture> getAll(){
		return repo.findAll();
	}
	
	public CompteEcriture getById(Long id) {
		return repo.findById(id).get();
	}
	
	public CompteEcriture add(CompteEcriture ligneEcriture) {
		return repo.save(ligneEcriture);
	}
	
	public CompteEcriture edit(Long id, CompteEcriture ligneEcriture) {
		
		if(repo.existsById(id)) {
			CompteEcriture entiter = repo.findById(id).get();
			
			entiter.setCompte(ligneEcriture.getCompte());
			entiter.setCredit(ligneEcriture.getCredit());
			entiter.setObservation(ligneEcriture.getObservation());
			entiter.setDebit(ligneEcriture.getDebit());
			entiter.setEcriture(ligneEcriture.getEcriture());
			//entiter.setReference(ligneEcriture.getReference());
			
			return repo.save(entiter);
		}
		return null;
	}
	
	public boolean delete (Long id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}

	public void deleteLot(List<CompteEcriture> l){
		repo.deleteAll(l);
	}

	public List<CompteEcriture> linesOf(String num){
		return repo.linesOf(num);
	}
}
