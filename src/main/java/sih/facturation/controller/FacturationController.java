package sih.facturation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sih.facturation.entities.Caisse;
import sih.facturation.entities.Caissier;
import sih.facturation.entities.ModePaiement;
import sih.facturation.services.CaisseService;
import sih.facturation.services.ModePaiementService;

@RestController
@RequestMapping("/fact/")
public class FacturationController {
	@Autowired
	private ModePaiementService mod;
	@Autowired
	private CaisseService cas;
	
	
	@GetMapping("modepaiement/list")
	public List<ModePaiement> listMod(){
		return mod.findAll();
	}

	@GetMapping("modepaiement/cod?={cod}")
	public ModePaiement findMode(@PathVariable String cod) {
		return mod.select(cod);
	}
	
	@PostMapping("modepaiement/list")
	public ModePaiement addMode(@RequestBody ModePaiement elt) {
		return mod.insert(elt);
	}
	@PutMapping("modepaiement/list")
	public ModePaiement editMode(@RequestBody ModePaiement elt) {
		return mod.edit(elt);
	}
	@DeleteMapping("modepaiement/list")
	public void deleteMode(@RequestBody ModePaiement elt) {
		mod.delete(elt.getCodeModPay());
	}
	

	//////////Caisse
	@GetMapping("caisse/list")
	public List<Caisse> listCaisse(){
		return cas.listCaisse();
	}
	
	@GetMapping("caisse/byId/{cod}")
	public Caisse findCaisse(@PathVariable(name = "cod") String cod) {
		return cas.selectCaisse(cod);
	}
	
	@PostMapping("caisse/list")
	public Caisse addingCaisse(@RequestBody Caisse c){
		System.out.print(c.toString());
		return cas.saveCaisse(c);
	}
	
	@PutMapping("caisse/list")
	public Caisse editCaisse(@RequestBody Caisse c) {
		return cas.saveCaisse(c);
	}
	
	@DeleteMapping("caisse/list")
	public void deleteCaisse(Caisse c) {
		cas.delCaisse(c);
	}

	
	
	//////////Caissier
	@GetMapping("caissier/list")
	public List<Caissier> listCaissier(){
		return cas.listCaissier();
	}
	
	@GetMapping("caissier/byId/{id}")
	public Caissier findCaissier(@PathVariable(name = "id") Long id) {
		return cas.selectCaissier(id);
	}
	
	@PostMapping("caissier/list")
	public Caissier addingCaisser(Caissier c){
		return cas.saveCaissier(c);
	}
	
	@PutMapping("caissier/list")
	public Caissier editCaissier(@RequestBody Caissier c) {
		return cas.saveCaissier(c);
	}
	
	@DeleteMapping("caissier/list")
	public void deleteCaissier(@RequestBody Caissier c) {
		cas.delCaissier(c);
	}


}
