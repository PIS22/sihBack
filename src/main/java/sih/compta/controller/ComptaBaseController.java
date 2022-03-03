package sih.compta.controller;

import java.util.List;

import sih.compta.entities.Activite;
import sih.compta.entities.ActiviteBlock;
import sih.compta.entities.Compte;
import sih.compta.entities.CompteArticle;
import sih.compta.entities.CompteArticleBlock;
import sih.compta.entities.CompteBlock;
import sih.compta.entities.CompteCaisse;
import sih.compta.entities.CompteCaisseBlock;
import sih.compta.entities.EtatImmo;
import sih.compta.entities.EtatImmoBlock;
import sih.compta.entities.Journal;
import sih.compta.entities.JournalBlock;
import sih.compta.entities.Localisation;
import sih.compta.entities.LocalisationBlock;
import sih.compta.entities.NatureJournal;
import sih.compta.entities.NatureJournalBlock;
import sih.compta.entities.TypeAmort;
import sih.compta.entities.TypeAmortBlock;
import sih.compta.entities.TypeBudget;
import sih.compta.entities.TypeBudgetBlock;
import sih.compta.services.ActiviteService;
import sih.compta.services.CompteArticleService;
import sih.compta.services.CompteCaisseService;
import sih.compta.services.CompteService;
import sih.compta.services.EtatImmoService;
import sih.compta.services.JournalService;
import sih.compta.services.LocalisationService;
import sih.compta.services.NatureJournalService;
import sih.compta.services.TypeAmortService;
import sih.compta.services.TypeBudgetService;
import sih.securite.entities.Utilisateur;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "sih/compta/")
public class ComptaBaseController {
	
	private final CompteService compteService;
	private final TypeAmortService typeAmortService;
	private final CompteArticleService CompteArticleService;
	private final JournalService journalService;
	private final LocalisationService localisationService;
	private final EtatImmoService etatImmoService;
	private final ActiviteService activiteService;
	private final NatureJournalService natureJournalService;
	private  final TypeBudgetService typeBudgetservice;
	private  final  CompteCaisseService CompteCaisseService;

	public ComptaBaseController(CompteService compteService, TypeAmortService typeAmortService,
			CompteArticleService CompteArticleService, JournalService journalService,
			LocalisationService localisationService, EtatImmoService etatImmoService, ActiviteService activiteService,
			NatureJournalService natureJournalService, TypeBudgetService typeBudgetservice, //BudgetService budgetService,
			CompteCaisseService compteCaisseService) {
		this.compteService = compteService;
		this.typeAmortService = typeAmortService;
		this.CompteArticleService = CompteArticleService;
		this.journalService = journalService;
		this.localisationService = localisationService;
		this.etatImmoService = etatImmoService;
		this.activiteService = activiteService;
		this.natureJournalService = natureJournalService;
		this.typeBudgetservice = typeBudgetservice;
		//this.budgetService = budgetService;
		CompteCaisseService = compteCaisseService;
	}

	/*
	 * ####################### 
	 * Partie réservée pour Compte
	 * ##########################
	 */

	@GetMapping(path = "compte/list")
	public List<Compte> getAllCompte() {
		return this.compteService.list();
	}

	@GetMapping(path = "compte/byTyp/{t}")
	public List<Compte> getCompteByType(String t) {
		return this.compteService.comptesParType(t);
	}

	@GetMapping(path = "compte/byCodCom/{id}")
	public Compte geCompteById(@PathVariable(name = "id") Long id) {
		return this.compteService.getById(id);
	}


	@PostMapping(path = "compte/list")
	public Compte createCompte(@RequestBody CompteBlock cpte) {
		return this.compteService.insert(cpte.getCompte(), cpte.getUser());
	}

	@PutMapping(path = "compte/byCodCom/{id}")
	public Compte updateCompte(@PathVariable(name = "id") Long id, @RequestBody CompteBlock cpte) {

		return this.compteService.edit(cpte.getCompte(),cpte.getUser());
	}

	@DeleteMapping(path = "compte/byCodCom/{id}")
	public void deleteCompte(@PathVariable(name = "id") Long id, Utilisateur us) {

		this.compteService.delete(id, us);
	}

	
	/*
	 * ####################### 
	 * Partie réservée pour TypeAmort
	 * ##########################
	 */

	
	@GetMapping(path = "typeAmort/list")
	public List<TypeAmort> getAllTypeAmort() {
		return this.typeAmortService.getAll();
	}

	@GetMapping(path = "typeAmort/byCodTypAmo/{id}")
	public TypeAmort getTypeAmortById(@PathVariable(name = "id") Long id) {
		return this.typeAmortService.getById(id);
	}


	@PostMapping(path = "typeAmort/list")
	public TypeAmort createTypeAmort(@RequestBody TypeAmortBlock blk) {
		return this.typeAmortService.insert(blk.getTypAmor(), blk.getUse());
	}

	@PutMapping(path = "typeAmort/byCodTypAmo/{id}")
	public TypeAmort updateTypeAmort(@PathVariable(name = "id") Long id, @RequestBody TypeAmortBlock blk) {

		return this.typeAmortService.edit(blk.getTypAmor(), blk.getUse());
	}

	@DeleteMapping(path = "typeAmort/byCodTypAmo/{id}")
	public void deleteTypeAmort(@PathVariable(name = "id") Long id, @RequestBody Utilisateur us) {

		this.typeAmortService.delete(id, us);
	}
	
	
	
	
	/*
	 * ####################### 
	 * Partie réservée pour CompteArticle
	 * ##########################
	 */
	
	@GetMapping(path = "CompteArticle/list")
	public List<CompteArticle> getAllCompteArticle() {
		return this.CompteArticleService.getAll();
	}

	@GetMapping(path = "CompteArticle/byCodAsso/{id}")
	public CompteArticle getCompteArticleById(@PathVariable(name = "id") Long id) {
		return this.CompteArticleService.selectByID(id);
	}


	@PostMapping(path = "CompteArticle/list")
	public CompteArticle createCompteArticle(@RequestBody CompteArticleBlock cArt) {
		return this.CompteArticleService.insert(cArt.getComArt(),cArt.getUser());
	}

	@PutMapping(path = "CompteArticle/byCodAsso/{id}")
	public CompteArticle updateCompteArticle(@PathVariable(name = "id") Long id, @RequestBody CompteArticleBlock blk) {

		return this.CompteArticleService.edit( blk.getComArt(), blk.getUser());
	}

	@DeleteMapping(path = "CompteArticle/byCodAsso/{id}")
	public void deleteCompteArticle(@PathVariable(name = "id") Long id, @RequestBody Utilisateur us) {

		 this.CompteArticleService.delete(id, us);
	}
	
	
	
	/*
	 * ####################### 
	 * Partie réservée pour Journal
	 * ##########################
	 */

	@GetMapping(path = "compte/jn/{id}")
	public List<Compte> getEligible(@PathVariable (name = "id") Long id){
		return journalService.getEligible(id);
	}

	@GetMapping(path = "journal/!cod/{cjrn}")
	public List<Journal> getAutresJournaux(@PathVariable(name = "cjrn") String cjrn) {
		return this.journalService.getAutre(cjrn);
	}

	@GetMapping(path = "journal/list")
	public List<Journal> getAllJournal() {
		return this.journalService.getAll();
	}

	@GetMapping(path = "journal/byCodJour/{id}")
	public Journal getJournalById(@PathVariable(name = "id") Long id) {
		return this.journalService.getById(id);
	}


	@PostMapping(path = "journal/list")
	public Journal createJournal(@RequestBody JournalBlock journal) {
		return this.journalService.insert(journal.getJrn(),journal.getUs());
	}

	@PutMapping(path = "journal/byCodJour/{id}")
	public Journal updateJournal(@PathVariable(name = "id") Long id, @RequestBody JournalBlock journal) {

		return this.journalService.edit(journal.getJrn(), journal.getUs());
	}

	@DeleteMapping(path = "journal/byCodJour/{id}")
	public void deleteJournal(@PathVariable(name = "id") Long id,@RequestBody Utilisateur us) {

		 this.journalService.delete(id,us);
	}
	
	
	/*
	 * ####################### 
	 * Partie réservée pour Localisation
	 * ##########################
	 */
	

		@GetMapping(path = "localisation/list")
		public List<Localisation> getAllLocalisation() {
			return this.localisationService.getAll();
		}
	
		@GetMapping(path = "localisation/byCodLocali/{id}")
		public Localisation getLocalisationById(@PathVariable(name = "id") Long id) {
			return this.localisationService.getById(id);
		}
	
	
		@PostMapping(path = "localisation/list")
		public Localisation createLocalisation(@RequestBody LocalisationBlock blk) {
			return this.localisationService.insert(blk.getLoc(), blk.getUse());
		}
	
		@PutMapping(path = "localisation/byCodLocali/{id}")
		public Localisation updateLocalisation(@PathVariable(name = "id") Long id, @RequestBody LocalisationBlock blk) {
	
			return this.localisationService.edit(blk.getLoc(), blk.getUse());
		}
	
		@DeleteMapping(path = "localisation/byCodLocali/{id}")
		public void deleteLocalisation(@PathVariable(name = "id") Long id, @RequestBody Utilisateur us) {
	
			this.localisationService.delete(id, us);
		}
		
		
		/*
		 * ####################### 
		 * Partie réservée pour EtatImmo
		 * ##########################
		 */
		

			@GetMapping(path = "etatImmo/list")
			public List<EtatImmo> getAllEtatImmo() {
				return this.etatImmoService.getAll();
			}
		
			@GetMapping(path = "etatImmo/byCodEtaImm/{id}")
			public EtatImmo getEtatImmoById(@PathVariable(name = "id") Long id) {
				return this.etatImmoService.getById(id);
			}
		
		
			@PostMapping(path = "etatImmo/list")
			public EtatImmo createEtatImmo(@RequestBody EtatImmoBlock blk) {
				return this.etatImmoService.insert(blk.getEta(), blk.getUse());
			}
		
			@PutMapping(path = "etatImmo/byCodEtaImm/{id}")
			public EtatImmo updateEtatImmo(@PathVariable(name = "id") Long id, @RequestBody EtatImmoBlock blk) {
		
				return this.etatImmoService.edit(blk.getEta(),blk.getUse());
			}
		
			@DeleteMapping(path = "etatImmo/byCodEtaImm/{id}")
			public void deleteEtatImmo(@PathVariable(name = "id") Long id, @RequestBody Utilisateur us) {
		
				 this.etatImmoService.delete(id, us);
			}
			
			
			/*
			 * ####################### 
			 * Partie réservée pour Activite
			 * ##########################
			 */
			

				@GetMapping(path = "activite/list")
				public List<Activite> getAllActivite() {
					return this.activiteService.getAll();
				}
			
				@GetMapping(path = "activite/byCodAct/{id}")
				public Activite getActiviteById(@PathVariable(name = "id") Long id) {
					return this.activiteService.select(id);
				}
			
			
				@PostMapping(path = "activite/list")
				public Activite createActivite(@RequestBody ActiviteBlock blk) {
					return this.activiteService.insert(blk.getActivite(), blk.getUser());
				}
			
				@PutMapping(path = "activite/byCodAct/{id}")
				public Activite updateActivite(@PathVariable(name = "id") Long id, @RequestBody ActiviteBlock blk) {
			
					return this.activiteService.edit(blk.getActivite(),blk.getUser());
				}
			
				@DeleteMapping(path = "activite/byCodAct/{id}")
				public void deleteActivite(@PathVariable(name = "id") Long id, @RequestBody Utilisateur us) {
			
					this.activiteService.delete(id, us);
				}


	/*
	 * #######################
	 * Partie réservée pour NatureJournal
	 * ##########################
	 */


	@GetMapping(path = "natJrn/list")
	public List<NatureJournal> getAllNatureJournal() {
		return this.natureJournalService.getAll();
	}

	@GetMapping(path = "natJrn/byIdNatJrn/{id}")
	public NatureJournal getNatureJournalById(@PathVariable(name = "id") Long id) {
		return this.natureJournalService.getById(id);
	}


	@PostMapping(path = "natJrn/list")
	public NatureJournal createNatureJournal(@RequestBody NatureJournalBlock blk) {
		return this.natureJournalService.insert(blk.getNatJrn(), blk.getUse());
	}

	@PutMapping(path = "natJrn/byIdNatJrn/{id}")
	public NatureJournal updateNatureJournal(@PathVariable(name = "id") Long id, @RequestBody NatureJournalBlock blk) {

		return this.natureJournalService.edit(blk.getNatJrn(), blk.getUse());
	}

	@DeleteMapping(path = "natJrn/byIdNatJrn/{id}")
	public void deleteNatureJournal(@PathVariable(name = "id") Long id, @RequestBody Utilisateur us) {

		this.natureJournalService.delete(id, us);
	}
	/*
	 * #######################
	 * Partie réservée pour typeBudget
	 * ##########################
	 */


	@GetMapping(path = "natBud/list")
	public List<TypeBudget> getAllTypeBudget() {
		return this.typeBudgetservice.getAll();
	}

	@GetMapping(path = "natBud/byCodNat/{id}")
	public TypeBudget getTypeBudgetById(@PathVariable(name = "id") Long id) {
		return this.typeBudgetservice.getById(id);
	}


	@PostMapping(path = "natBud/list")
	public TypeBudget createTypeBudget(@RequestBody TypeBudgetBlock tBudg) {
		return this.typeBudgetservice.insert(tBudg.getTypBud(),tBudg.getUse());
	}

	@PutMapping(path = "natBug/byCodNat/{id}")
	public TypeBudget updateTypeBudget(@PathVariable(name = "id") Long id, @RequestBody TypeBudgetBlock blk) {

		return this.typeBudgetservice.edit(blk.getTypBud(), blk.getUse());
	}

	@DeleteMapping(path = "natBug/byCodNat/{id}")
	public void deleteTypeBudget(@PathVariable(name = "id") Long id, @RequestBody Utilisateur us) {

		this.typeBudgetservice.delete(id, us);
	}
	/*
	 * #######################
	 * Partie réservée pour Budget
	 * ##########################
	 */


	/*@GetMapping(path = "bdg/list")
	public List<Budget> getAllBudget() {
		return this.budgetService.getAll();
	}

	@GetMapping(path = "bdg/byIdBdg/{id}")
	public Budget getBudgetById(@PathVariable(name = "id") Long id) {
		return this.budgetService.getById(id);
	}


	@PostMapping(path = "bdg/list")
	public Budget createBudget(@RequestBody Budget bdg) {
		return this.budgetService.insert(bdg);
	}

	@PutMapping(path = "bdg/byIdBdg/{id}")
	public Budget updateBudget(@PathVariable(name = "id") Long id, @RequestBody Budget bdg) {

		return this.budgetService.edit(id, bdg);
	}

	@DeleteMapping(path = "bdg/byIdBdg/{id}")
	public Boolean deleteBudget(@PathVariable(name = "id") Long id) {

		return this.budgetService.delete(id);
	}*/


	/*
	 * #######################
	 * Partie réservée pour CompteCaisse
	 * ##########################
	 */


	@GetMapping(path = "coca/list")
	public List<CompteCaisse> getAllCompteCaisse() {
		return this.CompteCaisseService.getAll();
	}

	@GetMapping(path = "coca/byIdCoCa/{id}")
	public CompteCaisse getCompteCaisseById(@PathVariable(name = "id") Long id) {
		return this.CompteCaisseService.getById(id);
	}


	@PostMapping(path = "coca/list")
	public CompteCaisse createCompteCaisse(@RequestBody CompteCaisseBlock blk) {
		return this.CompteCaisseService.insert(blk.getCoca(), blk.getUse());
	}

	@PutMapping(path = "coca/byIdCoCa/{id}")
	public CompteCaisse updateCompteCaisse(@PathVariable(name = "id") Long id, @RequestBody CompteCaisseBlock blk) {

		return this.CompteCaisseService.edit(blk.getCoca(), blk.getUse());
	}

	@DeleteMapping(path = "coca/byIdCoCa/{id}")
	public void deleteCompteCaisse(@PathVariable(name = "id") Long id, @RequestBody Utilisateur us) {

		this.CompteCaisseService.delete(id, us);
	}

}
