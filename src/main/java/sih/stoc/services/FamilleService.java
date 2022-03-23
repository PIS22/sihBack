package sih.stoc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.securite.entities.Objet;
import sih.securite.repositories.AgirRepo;
import sih.securite.repositories.ObjetRepo;
import sih.stoc.entities.Famille;
import sih.stoc.repositories.FamilleRepo;

@Service
public class FamilleService {
	@Autowired
	private ObjetRepo orepo;
	private final FamilleRepo repo;

	public FamilleService(FamilleRepo repo, AgirRepo aux) {
		super();
		this.repo = repo;
	}

	public Famille insert(Famille elt) {
		try {
			return repo.save(elt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// Modification
	public Famille edit(Famille elt) {
		try {
			return repo.save(elt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void delete(Famille elt) {
		try {
			repo.deleteById(elt.getCodFam());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Famille> list() {
		try {
			if (!orepo.existsById("Famille")) {
				try {
					orepo.save(new Objet("Famille", "idFam; codFam; libFam"));
				} catch (Exception e) {
					System.out.printf("Insertion: ", e.getCause());
				}
			}
		return repo.findAll();
		} catch (Exception e) {
			System.out.printf("Vérification: ", e.getMessage());
			return null;
		}
	}

	public void deleteById(String id, String log) {
		repo.deleteById(id);
	}

	public Famille select(String id) {
		return repo.findById(id).get();
	}

}
