package sih.compta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sih.compta.entities.CompteBudget;
import sih.compta.entities.CompteEcriture;
import sih.compta.entities.Ecriture;
import sih.compta.entities.Immo;
import sih.compta.entities.ImmoBlock;
import sih.compta.services.CompteBudgetService;
import sih.compta.services.CompteEcritureService;
import sih.compta.services.EcritureService;
import sih.compta.services.ImmoService;
import sih.securite.entities.Utilisateur;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/sih/compta/")
public class ComptaTraitementController {
	@Autowired
	private ImmoService immoService;
	@Autowired
	private EcritureService ecritureService;
	@Autowired
	private CompteEcritureService CompteEcritureService;
	@Autowired
	private CompteBudgetService compteBudgetService;

	/*
	 * #######################
	 * Partie réservée pour Immo
	 * ##########################
	 */

	@GetMapping(path = "immo/list")
	public List<Immo> getAllImmo() {
		return this.immoService.getAll();
	}

	@GetMapping(path = "immo/byCodImmo/{id}")
	public Immo getImmoById(@PathVariable(name = "id") Long id) {
		return this.immoService.getById(id);
	}


	@PostMapping(path = "immo/list")
	public Immo createImmo(@RequestBody ImmoBlock immo) {
		return this.immoService.insert(immo.getImmo(), immo.getUser());
	}

	@PutMapping(path = "immo/byCodImmo/{id}")
	public Immo updateImmo(@PathVariable(name = "id") Long id, @RequestBody ImmoBlock immo) {

		return this.immoService.edit(immo.getImmo(), immo.getUser());
	}

	@DeleteMapping(path = "immo/byCodImmo/{id}")
	public void deleteImmo(@PathVariable(name = "id") Long id, @RequestBody Utilisateur us) {

		this.immoService.delete(id, us);
	}


	/*
	 * #######################
	 * Partie réservée pour Ecriture
	 * ##########################
	 */

	/*@PostMapping("ecriture/list/ojd")
	public List<Ecriture> findOpcaisseOfDay(@RequestBody EcriJour ej) {

		Long us = ej.getUser();
		Long jn = ej.getJrn();

		List<Ecriture> ecritures = ecrire.getAllEcritureOfDay(us,jn);

		return ecritures;
	}*/

	@GetMapping(path = "ecriture/list")
	public List<Ecriture> getAllEcriture() {
		return this.ecritureService.getAll();
	}

	@GetMapping(path = "ecriture/byCodEcri/{id}")
	public Ecriture getEcritureById(@PathVariable(name = "id") String id) {
		return this.ecritureService.getById(id);
	}

	/*@PostMapping(path = "ecriture/list")
	public Ecriture createEcriture(@RequestBody Ecriture ecriture) {
		return this.ecritureService.insert(ecriture);
	}

	@PostMapping(path = "ecriture/annul")
	public Ecriture annulEcrit(@RequestBody EcritureBlock block) {
		Ecriture e= ecritureService.getById(block.getE().getRefIntern());
		e.setValide(false);
		if(ecritureService.edit(e.getNumEcri(),e) !=null){
			return this.ecritureService.insertEriture(block);
		}
		return null;
	}

	@PostMapping(path = "ecriture/edit")
	public Ecriture editBloc(@RequestBody EcritureBlock block) {
		return ecritureService.editBloc(block);
	}

	@PostMapping(path = "ecriture/blk")
	public Ecriture insertBlock(@RequestBody EcritureBlock block) {
		return this.ecritureService.insertEriture(block);
	}

	@PutMapping(path = "ecriture/byCodEcri/{id}")
	public Ecriture updateEcriture(@PathVariable(name = "id") String id, @RequestBody Ecriture ecriture) {

		return this.ecritureService.edit(id, ecriture);
	}

	@DeleteMapping(path = "ecriture/byCodEcri/{id}")
	public Boolean deleteEcriture(@PathVariable(name = "id") String id) {
		return this.ecritureService.delete(id);
	}


	/*
	 * #######################
	 * Partie réservée pour CompteEcriture
	 * ##########################
	 */


	@GetMapping(path = "CompteEcriture/list")
	public List<CompteEcriture> getAllCompteEcriture() {
		return this.CompteEcritureService.getAll();
	}

	@GetMapping(path = "CompteEcriture/list/ecriture/{num}")
	public List<CompteEcriture> getLinesOf(@PathVariable(name = "num") String num) {
		return this.CompteEcritureService.linesOf(num);
	}

	@GetMapping(path = "CompteEcriture/byCodLigEcr/{id}")
	public CompteEcriture getCompteEcritureById(@PathVariable(name = "id") Long id) {
		return this.CompteEcritureService.getById(id);
	}

	/*@PostMapping(path = "CompteEcriture/list")
	public CompteEcriture createCompteEcriture(@RequestBody CompteEcriture CompteEcriture) {
		return this.CompteEcritureService.insert(CompteEcriture);
	}*/

	@PutMapping(path = "CompteEcriture/byCodLigEcr/{id}")
	public CompteEcriture updateCompteEcriture(@PathVariable(name = "id") Long id, @RequestBody CompteEcriture CompteEcriture) {
		return this.CompteEcritureService.edit(id, CompteEcriture);
	}

	@DeleteMapping(path = "CompteEcriture/byCodLigEcr/{id}")
	public Boolean deleteCompteEcriture(@PathVariable(name = "id") Long id) {
		return this.CompteEcritureService.delete(id);
	}



	/*
	 * #######################
	 * Partie réservée pour CompteBudget
	 * ##########################
	 */


	@GetMapping(path = "lBdg/list")
	public List<CompteBudget> getAllLigneLBdg() {
		return compteBudgetService.getAll();
	}

	@GetMapping(path = "lBdg/byCodLBdg/{id}")
	public CompteBudget getCompteBudget(@PathVariable(name = "id") Long id) {
		return this.compteBudgetService.getById(id);
	}


	/*@PostMapping(path = "lBdg/list")
	public CompteBudget createCompteBudget(@RequestBody CompteBudget lbdg) {
		return this.compteBudgetService.insert(lbdg);
	}*/

	@PutMapping(path = "lBdg/byCodLigBdg/{id}")
	public CompteBudget updateLigneBudget(@PathVariable(name = "id") Long id, @RequestBody CompteBudget lBdg) {
		return this.compteBudgetService.edit(id, lBdg);
	}

	@DeleteMapping(path = "lBdg/byCodLigBdg/{id}")
	public Boolean deleteCompteBudget(@PathVariable(name = "id") Long id) {
		return this.CompteEcritureService.delete(id);
	}

}
