package sih.compta.services;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.compta.entities.NatureJournal;
import sih.compta.repositories.NatureJournalRepository;
import sih.securite.entities.Agir;
import sih.securite.entities.Utilisateur;
import sih.securite.repositories.AgirRepo;
import sih.securite.repositories.ObjetRepo;


@Service
public class NatureJournalService {

	private final NatureJournalRepository repo;
	private final AgirRepo aux;	
	@Autowired
	private ObjetRepo orepo;
	
	public NatureJournalService(NatureJournalRepository repo, AgirRepo aux) {
		super();
		this.repo = repo;
		this.aux = aux;
	}

	public List<NatureJournal> getAll(){
		if(repo.findAll().isEmpty()) {
			List<NatureJournal> nj = new ArrayList<>();
			nj.add(new NatureJournal("N1", "Amortissement"));
			nj.add(new NatureJournal("N2", "Engagement"));
			nj.add(new NatureJournal("N3", "Report"));
			nj.add(new NatureJournal("N4", "Resultat"));
			nj.add(new NatureJournal("N5", "Fonctionnement"));
			repo.saveAll(nj);
		}
		return repo.findAll();
	}
	
	public NatureJournal getById(Long id) {
		return repo.findById(id).get();
	}
	
	public NatureJournal insert(NatureJournal elt,Utilisateur us) {
		NatureJournal nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("NatureJournal").get());
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public NatureJournal edit(NatureJournal elt,Utilisateur us) {
		NatureJournal ancien=repo.findById(elt.getIdNat()).get();
		NatureJournal nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("Magasin").get());
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		NatureJournal ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setTable(orepo.findById("Magasin").get());
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
}
