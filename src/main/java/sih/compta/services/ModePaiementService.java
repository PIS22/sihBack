package sih.compta.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.compta.entities.ModePaiement;
import sih.compta.repositories.ModePaiementRepository;
import sih.securite.entities.Agir;
import sih.securite.entities.Utilisateur;
import sih.securite.repositories.AgirRepo;
import sih.securite.repositories.ObjetRepo;

@Service
public class ModePaiementService {
	private final ModePaiementRepository repo;
	private final AgirRepo aux;
	@Autowired
	private ObjetRepo orepo;
	
	public ModePaiementService(ModePaiementRepository repos, AgirRepo aux) {
		super();
		this.repo = repos;
		this.aux = aux;
	}

	
	public ModePaiement insert(ModePaiement elt,Utilisateur us) {
		ModePaiement nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("Magasin").get());
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public ModePaiement edit(ModePaiement elt,Utilisateur us) {
		ModePaiement ancien=repo.findById(elt.getIdMod()).get();
		ModePaiement nouveau= repo.save(elt);
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
		ModePaiement ancien=repo.findById(id).get();
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
	
	public ModePaiement select(Long id){
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
