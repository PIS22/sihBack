package sih.general.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.general.entities.Exercice;
import sih.general.repositories.ExerciceRepo;

@Service

public class ExerciceService {
	@Autowired
	private ExerciceRepo repo;

	public Exercice insert(Exercice elt) {
		try {
			return repo.save(elt);
		} catch (Exception e) {
			return null;
		}
	}
	
	public Exercice edit(Exercice elt) {
		try {
			return repo.save(elt);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
	}
	
	public void delete(int id) {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
	
	public List<Exercice> list(){
		return repo.findAll();
	}
	
	public Exercice select(int id) {
		return repo.findById(id).get();
	}

	public List<Exercice> findByEtat(String eta) {
		return repo.findByEtaExo(eta);
	}

	

}
