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
		//Famille nouveau = 
		/*try {
			if (!nouveau.equals(null)) {
				Agir act = new Agir();
				act.setNouvellesValeurs(nouveau.element());
				act.setTable(orepo.findById("Famille").get());
				act.setUser(u.findByLogin(elt.getLogin()));
				act.setDatActe(LocalDateTime.now());
				act.setAction("Ajout");
				aux.save(act);
				return nouveau;
			}
			return null;
		} catch (Exception e) {
			System.out.print(e.getCause());
			return null;
		}*/
	}

	// Modification
	public Famille edit(Famille elt) {
		System.out.print(elt);
		try {
			return repo.save(elt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		/*Agir act = new Agir();
		act.setAnciennesValeurs(repo.findById(elt.getFam().getIdFam()).get().toString());
		Famille nouveau = repo.save(elt.getFam());
		if (!nouveau.equals(null)) {
			act.setNouvellesValeurs(nouveau.toString());
			act.setTable(orepo.findById("Famille").get());
			act.setDatActe(LocalDateTime.now());
			act.setUser(u.findByLogin(elt.getLogin()));
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}*/
		
	}

	public void delete(Famille elt) {
		try {
			repo.deleteById(elt.getCodFam());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		/*Famille ancien = elt.getFam();
		if (!ancien.equals(null)) {
			// repo.deleteById(elt.getFam().getIdFam());
			if (!repo.existsById(elt.getFam().getIdFam())) {
				Agir act = new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setTable(orepo.findById("Famille").get());
				act.setDatActe(LocalDateTime.now());
				act.setUser(u.findByLogin(elt.getLogin()));
				act.setAction("Supression");
				// aux.save(act);
			}
		}*/
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
		/*if (repo.findById(id) != null) {
			Agir a = new Agir();
			a.setAction("Suppression");
			a.setAnciennesValeurs(f.toString());
			a.setDatActe(LocalDateTime.now());
			a.setTable(orepo.findById("Famille").get());
			a.setUser(u.findByLogin(log));
			aux.save(a);
		}*/
	}

	public Famille select(String id) {
		return repo.findById(id).get();
	}

}
