package sih.compta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.compta.entities.TypeBudget;
import sih.compta.repositories.TypBdgRepository;
import sih.securite.entities.Agir;
import sih.securite.entities.Utilisateur;
import sih.securite.repositories.AgirRepo;
import sih.securite.repositories.ObjetRepo;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TypeBudgetService {
	
	@Autowired
	private ObjetRepo orepo;

        private final TypBdgRepository repo;
        private final AgirRepo aux;

    public TypeBudgetService(TypBdgRepository repo, AgirRepo aux) {
			super();
			this.repo = repo;
			this.aux = aux;
		}

	public List<TypeBudget> getAll(){
            return repo.findAll();
        }

        public TypeBudget getById(Long id) {
            return repo.findById(id).get();
        }

	public TypeBudget insert(TypeBudget elt,Utilisateur us) {
		TypeBudget nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("TypeBudget").get());
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public TypeBudget edit(TypeBudget elt,Utilisateur us) {
		TypeBudget ancien=repo.findById(elt.getIdTypBdg()).get();
		TypeBudget nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("TypeBudget").get());
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		TypeBudget ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setTable(orepo.findById("TypeBudget").get());
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
}
