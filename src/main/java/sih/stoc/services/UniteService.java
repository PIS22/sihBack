package sih.stoc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.securite.entities.Objet;
import sih.securite.repositories.ObjetRepo;
import sih.stoc.entities.Unite;
import sih.stoc.repositories.UniteRepo;

@Service
public class UniteService {
	@Autowired
	private ObjetRepo orepo;
	@Autowired
	private UniteRepo repo;

	public Unite insert(Unite elt) {
		
		try {
			return repo.save(elt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			return null;
		}
/*
		Unite nouveau = repo.save(elt);
		try {
			if (!nouveau.equals(null)) {
				Agir act = new Agir();
				act.setNouvellesValeurs(nouveau.element());
				act.setTable(orepo.findById("Unite").get());
				act.setUser(u.findByLogin(log));
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
	public Unite edit(Unite elt) {

		
		try {
			return repo.save(elt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			return null;
		}
			
		/*ir act = new Agir();
		act.setAnciennesValeurs(repo.findById(elt.getUnite().getIdUnit()).get().toString());
		Unite nouveau = repo.save(elt.getUnite());
		if (!nouveau.equals(null)) {
			act.setNouvellesValeurs(nouveau.toString());
			act.setTable(orepo.findById("Famille").get());
			act.setDatActe(LocalDateTime.now());
			act.setUser(u.findByLogin(elt.getLogin()));
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;*/
	}

	public void delete(Unite elt) {
		
		try {
			 repo.delete(elt);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
		}
		
		/*System.out.println(elt);
		Unite ancien = elt.getUnite();
		if (!ancien.equals(null)) {
			// repo.deleteById(elt.getFam().getIdFam());
			if (!repo.existsById(elt.getUnite().getIdUnit())) {
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

	public List<Unite> list() {
		try {
			if (!orepo.existsById("Unite")) {
				try {
					orepo.save(new Objet("Unite", "idUnit; codUnit; libUnit"));
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

	public void deleteById(String id) {
		repo.deleteById(id);
	}

	public Unite select(String id) {
		return repo.findById(id).get();
	}

	
}