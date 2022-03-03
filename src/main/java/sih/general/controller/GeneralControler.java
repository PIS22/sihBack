package sih.general.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sih.general.entities.Centre;
import sih.general.entities.CentreBlock;
import sih.general.entities.Commune;
import sih.general.entities.CommuneBlock;
import sih.general.entities.DDS;
import sih.general.entities.DDSBlock;
import sih.general.entities.Exercice;
import sih.general.entities.ExerciceBlock;
import sih.general.entities.PharmaBlock;
import sih.general.entities.Pharmacie;
import sih.general.entities.ServeBlock;
import sih.general.entities.ServicesSpecialises;
import sih.general.entities.TypeCentre;
import sih.general.entities.TypeCentreBlock;
import sih.general.entities.ZoneSanitaire;
import sih.general.entities.ZoneSanitaireBlock;
import sih.general.services.CentreService;
import sih.general.services.CommuneService;
import sih.general.services.DDSService;
import sih.general.services.ExerciceService;
import sih.general.services.PharmaService;
import sih.general.services.ServSpeService;
import sih.general.services.TypeCentreService;
import sih.general.services.ZsService;
@RestController
@RequestMapping(path = "/")
@CrossOrigin("*")
public class GeneralControler {
	private final ExerciceService exo;
	private final DDSService dds;
	private final ZsService zone;
	private final CommuneService com;
	private final TypeCentreService type;
	private final CentreService centre;
	private final ServSpeService serve;
	private final PharmaService pharma;

	public GeneralControler(ExerciceService exo, DDSService dds, ZsService zone, CommuneService com,
			TypeCentreService type, CentreService centre, ServSpeService serve, PharmaService pharma) {
		super();
		this.exo = exo;
		this.dds = dds;
		this.zone = zone;
		this.com = com;
		this.type = type;
		this.centre = centre;
		this.serve = serve;
		this.pharma = pharma;
	}

	//////////////Interaction sur exercice
	@GetMapping("exercice/list")
	public List<Exercice> listExercice(){
		return exo.list();
	}

	@GetMapping("exercice/byId/{id}")
	public Exercice findExercice(@PathVariable(name = "id") int id) {
		return exo.select(id);
	}

	@GetMapping("exercice/byEtat/{eta}")
	public List<Exercice> findExerciceByEtat(@PathVariable(name = "eta") String eta) {
		return exo.findByEtat(eta);
	}

	
	@GetMapping("exercice/byEtat/{id}")
	public List<Exercice> findByEta(@PathVariable(name = "id") String id) {
		return exo.findByEtat(id);
	}
	
	@PostMapping("exercice/list")
	Exercice addingExercice(@RequestBody ExerciceBlock e){
		return exo.insert(e.getExo(), e.getAuteur());
	}
	
	@PutMapping("exercice/list")
	public Exercice editingExercice(@RequestBody ExerciceBlock bloc) {
		return exo.edit(bloc.getExo(), bloc.getAuteur());
	}
	
	@DeleteMapping("exercice/byId/{id}")
	public boolean deletingExercice( @PathVariable(name = "id") int id) {
		return exo.delete(id);
	}
	
	//**************** Interaction sur l'entity DDS **********//
	  @GetMapping("dds/list")
	public List<DDS> listDDS() {//Methode d'affichage des DDS
	return dds.list();
	}
	
	  @GetMapping("dds/parId/{id}")
	  public DDS findDDS(@PathVariable (name = "id") long id) {// Methode d'affichage de DDS par Recherche de son Id
		return dds.select(id);  
	  }
	  @PostMapping("dds/list")
	  DDS addingDDS (@RequestBody DDSBlock bloc){// Methode d'insertion de nouveau DDS par edition
		  return dds.insert(bloc.getDds(), bloc.getAuteur());
	  }
	  @PutMapping("dds/list")
		public DDS editingDDS(@RequestBody DDSBlock bloc) {// Methode modification de DDS
			return dds.edit(bloc.getDds(), bloc.getAuteur());
		}
	  @DeleteMapping("dds/list")
		public void deletingDDS(DDSBlock bloc) {// Methode de suppression de dds
			dds.delete(bloc.getDds().getIddds(), bloc.getAuteur());
			
			//********* Fin des Methodes DDS*********//
		}
	  
	//**************** Interaction sur l'entity Zone Sanitaire **********//
	  @GetMapping("zone/list")
	public List<ZoneSanitaire> listZoneSanitaire() {
	return zone.list();
	}
	
	  @GetMapping("zone/parId/{id}")
	  public ZoneSanitaire findZone(@PathVariable (name = "id") long id) {
		return zone.select(id);  
	  }
	  @PostMapping("zone/list")
	  ZoneSanitaire addingZoneSanitaire (@RequestBody ZoneSanitaireBlock bloc){
		  return zone.insert(bloc.getZone(), bloc.getAuteur());
	  }
	  @PutMapping("zone/list")
		public ZoneSanitaire editingZoneSanitaire(@RequestBody ZoneSanitaireBlock bloc) {
			return zone.edit(bloc.getZone(), bloc.getAuteur());
		}
	  @DeleteMapping("zone/list")
		public void deletingDDS(ZoneSanitaireBlock bloc) {
			zone.delete(bloc.getZone().getIdZS(), bloc.getAuteur());
			
			//********* Fin des Methodes Zone Sanitaire*********//
		}
	//**************** Interaction sur l'entity Commune **********//
	  @GetMapping("com/list")
	public List<Commune> listZonecommune() {//Methode d'affichage des DDS
	return com.list();
	}
	
	  @GetMapping("com/parId/{id}")
	  public Commune findCommune(@PathVariable (name = "id") long id) {// Methode d'affichage de DDS par Recherche de son Id
		return com.select(id);  
	  }
	  @PostMapping("com/list")
	  Commune addingCommune (@RequestBody CommuneBlock bloc){// Methode d'insertion de nouveau DDS par edition
		  return com.insert(bloc.getCom(), bloc.getAuteur());
	  }
	  @PutMapping("com/list")
		public Commune editingCommune(@RequestBody CommuneBlock bloc) {// Methode modification de DDS
			return com.edit(bloc.getCom(), bloc.getAuteur());
		}
	  @DeleteMapping("com/list")
		public void deletingCommune(CommuneBlock bloc) {// Methode de suppression de dds
			com.delete(bloc.getCom().getIdCom(), bloc.getAuteur());
			
			//********* Fin des Methodes Commune*********//
		}
	  
	//**************** Interaction sur l'entity Type Centre **********//
	  @GetMapping("type/list")
	public List<TypeCentre> listTypeCentre() {
	return type.list();
	}
	
	  @GetMapping("type/parId/{id}")
	  public TypeCentre findTypeCentre(@PathVariable (name = "id") long id) {
		return type.select(id);  
	  }
	  @PostMapping("type/list")
	  TypeCentre addingTypeCentre (@RequestBody TypeCentreBlock bloc){
		  return type.insert(bloc.getType(), bloc.getAuteur());
	  }
	  @PutMapping("type/list")
		public TypeCentre editingTypeCentre(@RequestBody TypeCentreBlock bloc) {
			return type.edit(bloc.getType(), bloc.getAuteur());
		}
	  @DeleteMapping("type/list")
		public void deletingTypeCentre(TypeCentreBlock bloc) {
			com.delete(bloc.getType().getIdTypeCentre(), bloc.getAuteur());
			
			//********* Fin des Methodes Type Centre*********//
		}
	  
	//**************** Interaction sur l'entity Centre **********//
	  @GetMapping("centre/list")
	public List<Centre> listCentre() {
	return centre.list();
	}
	
	  @GetMapping("centre/parId/{id}")
	  public Centre findCentre(@PathVariable (name = "id") long id) {
		return centre.select(id);  
	  }
	  @PostMapping("centre/list")
	  Centre addingCentre (@RequestBody CentreBlock bloc){
		  return centre.insert(bloc.getCentre(), bloc.getAuteur());
	  }
	  @PutMapping("centre/list")
		public Centre editingCentre(@RequestBody CentreBlock bloc) {
			return centre.edit(bloc.getCentre(), bloc.getAuteur());
		}
	  @DeleteMapping("centre/list")
		public void deletingCentre(CentreBlock bloc) {
			centre.delete(bloc.getCentre().getIdCentre(), bloc.getAuteur());
			
			//********* Fin des Methodes  Centre*********//
		}
	  
	//**************** Interaction sur l'entity Services Specialises **********//
	  @GetMapping("serve/list")
	public List<ServicesSpecialises> listServe() {
	return serve.list();
	}
	
	  @GetMapping("serve/parId/{id}")
	  public ServicesSpecialises findServe(@PathVariable (name = "id") long id) {
		return serve.select(id);  
	  }
	  @PostMapping("serve/list")
	  ServicesSpecialises addingServe (@RequestBody ServeBlock bloc){
		  return serve.insert(bloc.getServe(), bloc.getAuteur());
	  }
	  @PutMapping("serve/list")
		public ServicesSpecialises editingServe(@RequestBody ServeBlock bloc) {
			return serve.edit(bloc.getServe(), bloc.getAuteur());
		}
	  @DeleteMapping("serve/list")
		public void deletingServe(ServeBlock bloc) {
		  serve.delete(bloc.getServe().getIdServS(), bloc.getAuteur());
			
			//********* Fin des Methodes Services Specialises*********//
		}
	  
	//**************** Interaction sur l'entity Pharmacie **********//
	  @GetMapping("pharma/list")
	public List<Pharmacie> listPharma() {
	return pharma.list();
	}
	
	  @GetMapping("pharma/parId/{id}")
	  public Pharmacie findPharma(@PathVariable (name = "id") long id) {
		return pharma.select(id);  
	  }
	  @PostMapping("pharma/list")
	  Pharmacie addingPharma (@RequestBody PharmaBlock bloc){
		  return pharma.insert(bloc.getPharma(), bloc.getAuteur());
	  }
	  @PutMapping("pharma/list")
		public Pharmacie editingPharma(@RequestBody PharmaBlock bloc) {
			return pharma.edit(bloc.getPharma(), bloc.getAuteur());
		}
	  @DeleteMapping("pharma/list")
		public void deletingPharma(PharmaBlock bloc) {
		  pharma.delete(bloc.getPharma().getIdPharma(), bloc.getAuteur());
			
			//********* Fin des Methodes Pharmacie*********//
		}
}
