package sih.facturation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.facturation.entities.Caisse;
import sih.facturation.entities.Caissier;
import sih.facturation.repositories.CaisseRepo;
import sih.facturation.repositories.CaissierRepos;

@Service
public class CaisseService {
	@Autowired
	CaisseRepo car;
	@Autowired
	CaissierRepos cai;

	//////////// Caisse
	
	public List<Caisse> listCaisse(){
		return car.findAll();
	}
	
	public Caisse selectCaisse(String cod) {
		return car.getById(cod);
	}
	
	public Caisse saveCaisse(Caisse c) {
		return car.save(c);
	}
	
	public void delCaisse(Caisse c) {
		car.delete(c);
	}
	
	
	///Caissier (UtilisateurCaisse)
	public List<Caissier> listCaissier(){
		return cai.findAll();
	}
	
	public Caissier selectCaissier(Long id) {
		return cai.getById(id);
	}
	
	public Caissier saveCaissier(Caissier c) {
		return cai.save(c);
	}
	
	public void delCaissier(Caissier c) {
		cai.delete(c);
	}
	
	public  List<Caisse> caissesActuelles(Long us){
		return car.findAllById(cai.caissesActuelle(us));
		
	}

}
