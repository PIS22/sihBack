package sih.general.services;

import java.time.LocalDateTime;
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.general.entities.TypeCentre;
import sih.general.repositories.TypeCentreRepo;
import sih.securite.entities.Agir;
import sih.securite.entities.Utilisateur;
import sih.securite.repositories.AgirRepo;
import sih.securite.repositories.ObjetRepo;

	
	@Service
	public class TypeCentreService {

		//Declaration
		@Autowired
		private ObjetRepo orepo;
		private final TypeCentreRepo repo;
		private final AgirRepo aux;

	//Initialization into the constructor
		public TypeCentreService(TypeCentreRepo repo, AgirRepo aux) {
			super();
			this.repo = repo;
			this.aux = aux;
		}
		
		// Insertion
		public TypeCentre insert(TypeCentre elt, Utilisateur us) {
			TypeCentre nouveau= repo.save(elt);
			if(!nouveau.equals(null)) {
				Agir act=new Agir();
				act.setNouvellesValeurs(nouveau.element());
				act.setDatActe(LocalDateTime.now());
				act.setTable(orepo.findById("TypeCentre").get());
				act.setUser(us);
				act.setAction("Ajout");
				aux.save(act);
				return nouveau;
			}
			return null;
		}
		
		
		//Modification
		
		public TypeCentre edit(TypeCentre elt,Utilisateur us) {
			TypeCentre ancien=repo.findById(elt.getIdTypeCentre()).get();
			TypeCentre nouveau= repo.save(elt);
			if(!nouveau.equals(null)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setNouvellesValeurs(nouveau.element());
				act.setDatActe(LocalDateTime.now());
				act.setTable(orepo.findById("TypeCentre").get());
				act.setUser(us);
				act.setAction("Modification");
				aux.save(act);
				return nouveau;
			}
			return null;
		
		}
		
		
		public void delete(Long id,Utilisateur us) {
			TypeCentre ancien=repo.findById(id).get();
			if(!ancien.equals(null)) {
				repo.deleteById(id);
				if(!repo.existsById(id)) {
					Agir act=new Agir();
					act.setAnciennesValeurs(ancien.element());
					act.setDatActe(LocalDateTime.now());
					act.setTable(orepo.findById("TypeCentre").get());
					act.setUser(us);
					act.setAction("Supression");
					aux.save(act);
				}
			}
		}
		
		public List<TypeCentre> list(){
			return repo.findAll();
		}
		
		public TypeCentre select(Long id) {
			return repo.findById(id).get();
		}
}
