package sih.compta.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.compta.entities.Compte;
import sih.compta.entities.Journal;
import sih.compta.repositories.JournalRepository;
import sih.securite.entities.Agir;
import sih.securite.entities.Utilisateur;
import sih.securite.repositories.AgirRepo;
import sih.securite.repositories.ObjetRepo;


@Service
public class JournalService {
	private final JournalRepository repo;
	private final AgirRepo aux;	
	@Autowired
	private ObjetRepo orepo;

	public JournalService(JournalRepository repo, AgirRepo aux) {
		super();
		this.repo = repo;
		this.aux = aux;
	}

	public List<Compte> getEligible(Long id){

		List<Compte> eligible=new ArrayList<>();
		/*for (Compte c:repo.findById(id).get().getCompteAutorises()){
			eligible.addAll(repo.eligible(c.getNumCpte().concat("%")));
		}*/
		return eligible;
	}

	public List<Journal> getAll(){
		return repo.findAll();
	}


	public List<Journal> getAutre(String cjrn){
		return repo.autreJrn(cjrn);
	}

	public Journal getById(Long id) {
		return repo.findById(id).get();
	}
		
	public Journal insert(Journal elt,Utilisateur us) {
		Journal nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("Immo").get());
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public Journal edit(Journal elt,Utilisateur us) {
		Journal ancien=repo.findById(elt.getIdJrn()).get();
		Journal nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("Immo").get());
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		Journal ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setTable(orepo.findById("Immo").get());
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}

}
