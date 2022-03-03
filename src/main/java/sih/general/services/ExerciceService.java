package sih.general.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.general.entities.Exercice;
import sih.general.repositories.ExerciceRepo;
import sih.securite.entities.Agir;
import sih.securite.entities.Objet;
import sih.securite.entities.Utilisateur;
import sih.securite.repositories.AgirRepo;
import sih.securite.repositories.ObjetRepo;
import sih.securite.repositories.UtilisateurService;

@Service

public class ExerciceService {
	@Autowired
	private ObjetRepo orepo;
	@Autowired
	private UtilisateurService us;
	private final ExerciceRepo repo;
	private final AgirRepo aux;
	//Exercice e= new Exercice();

	public ExerciceService(ExerciceRepo repo, AgirRepo aux) {
		super();
		this.repo = repo;
		this.aux = aux;
	}

	public Exercice insert(Exercice elt, Utilisateur u) {
		
		Exercice nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.getById("Exercice"));
			act.setUser(us.findByLogin(u.getLogin()));
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public Exercice edit(Exercice elt,Utilisateur us) {
		Exercice ancien=repo.findById(elt.getCodExo()).get();
		Exercice nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.objetByLib("Exercice"));
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public boolean delete(int id) {
		//System.out.printf("Service :",u);
		if(!repo.findById(id).equals(null)) {
			//Agir act=new Agir();
			//act.setAnciennesValeurs(repo.findById(id).get().element());
			//Exercice ancien= repo.getById(id).toString();
			repo.deleteById(id);
			//System.out.print("Suppression");
			//if(!repo.existsById(id)) {
				//act.setDatActe(LocalDateTime.now());
				//act.setTable(orepo.findById("Exercice").get());
				//act.setUser(us.findByLogin(u.getLogin()));
				//act.setAction("Supression");
				//aux.save(act);
			//}
		}
		return !repo.existsById(id);
	}
	
	public List<Exercice> list(){
		
		if(!orepo.existsById("Exercice")) {
			try {
				orepo.save(new Objet("Exercice", "codExo; libExo; debExo; finExo; etaExo"));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return repo.findAll();
	}
	
	public Exercice select(int id) {
		return repo.findById(id).get();
	}

	public List<Exercice> findByEtat(String eta) {
		return repo.findByEtaExo(eta);
	}

	

}
