
package sih.general.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sih/general/espace/arrondissement")
@CrossOrigin("*")
public class ArrondissementController {
    /*@Autowired
    private final ArrondissementService arrondissementService;
    @Autowired
    private final AdresseService adresseService;
    @Autowired
    private final NaissanceService naissanceService;
    @Autowired
    private final MariageService mariageService;
    @Autowired
    private final DecesService decesService;
    @Autowired
    private final StatSyntheseService statSyntheseService;
    @Autowired
    private final PersonneService personneService;

    @GetMapping("/list")
    public List<Arrondissement> list() {
        return  setResponsableToString(this.arrondissementService.findAll());
    }

    @GetMapping("/search/{id}")
    public Arrondissement findById(@PathVariable(value="id") String id) {
        try {
            Arrondissement arrondissement = arrondissementService.findById(id);
            if(arrondissement.getAdresse() == null) {
                arrondissement.setAdresse(new Adresse());
            }
            return  arrondissement;
        } catch (Exception e) {
            return null;
        } 
    }  
    
    @GetMapping("/search-by-commune/{id}")
    public List<Arrondissement> findAllByCommune(@PathVariable(value="id") String id) {
        try {
            List<Arrondissement> arrondissements = arrondissementService.findAllByCommune(id);
            for (Arrondissement arrondissement : arrondissements) {
                arrondissement.setNombreHabitant(this.personneService.sizeOfByArrond(arrondissement.getId()));
            }
            return  arrondissements;
        } catch (Exception e) {
            return null;
        } 
    }
    
 
    @GetMapping("/synthese-arrond/{id}")
    public List<ArrondissementResume> findAllArrondSynthse(@PathVariable(value="id") String id) {
            List<ArrondissementResume> arrondissementResumes = new ArrayList<>();
        try {
            String [] tab = id.split("-");
            List<Arrondissement> arrondissements = this.arrondissementService.findAllByCommune(tab[0]);
            int annee = Integer.parseInt(tab[1]); int naissance = 0; int mariage = 0; int deces = 0; 
            String respo = ""; String description = "";
            
            
            for (Arrondissement arrondissement : arrondissements) {
                respo = "Non désigné";
                description = arrondissement.getDescription();
                naissance = this.naissanceService.sizeOfBirthdayByYearByArrond(arrondissement.getId(), annee);
                mariage = this.mariageService.sizeOfMariageByArrondByYear(arrondissement.getId(), annee);
                deces = this.decesService.sizeOfBirthdayByYearByArrond(arrondissement.getId(), annee);
                if(arrondissement.getResponsable() != null) {
                   respo = arrondissement.getResponsable().getUser().getNom()+ " " + arrondissement.getResponsable().getUser().getPrenom();
                }
                arrondissementResumes.add(new ArrondissementResume(description, annee, naissance, mariage, deces, respo));
                String idStat = arrondissement.getId()+ annee;
                this.statSyntheseService.save(new StatSynthese(idStat, annee, naissance, mariage, deces, respo, arrondissement.getCommune()));
            }
            // Arrondissement central
            respo = "Non désigné";
            description = "Central(Mairie)";
            naissance = this.naissanceService.sizeOfBirthdayByYearByComOnly(tab[0], annee);
            mariage   = this.mariageService.sizeOfMariageByComByYearOnly(tab[0], annee);
            deces = this.decesService.sizeOfBirthdayByYearByComOnly(tab[0], annee);
            if(arrondissements.get(0).getCommune().getResponsable() != null) {
                respo = arrondissements.get(0).getCommune().getResponsable().getUser().getNom() + " " +arrondissements.get(0).getCommune().getResponsable().getUser().getPrenom();
            }
            arrondissementResumes.add(new ArrondissementResume(description, annee, naissance, mariage, deces, respo));
            String idStat = arrondissements.get(0).getCommune().getId()+ annee;
            this.statSyntheseService.save(new StatSynthese(idStat, annee, naissance, mariage, deces, respo, arrondissements.get(0).getCommune()));
            
        } catch (Exception e) {
            
        } 
        return  arrondissementResumes;
    }  
    
    @GetMapping("/sizeof-arrond-com/{id}")
    public int sizeOfArrondissmentByCom(@PathVariable(value="id") String id) {
        return  arrondissementService.sizeOfArrondissmentByCom(id);
    } 
    
    @GetMapping("/sizeof-arrond")
    public int sizeOfArrondissment() {
        return  arrondissementService.sizeOfArrondissment();
    }
    
    @PostMapping("/insert")
    public Arrondissement doCreate(@Valid @RequestBody Arrondissement arrondissement) {
        try {
            Adresse adresse = null;
            if(arrondissement.getAdresse() != null) {
               adresse =  this.adresseService.save(arrondissement.getAdresse()); 
            }else {
                adresse = this.adresseService.save(new Adresse());                
            }
            arrondissement.setAdresse(adresse);
            return this.arrondissementService.save(arrondissement);
        } catch (Exception e) {
            return null;
        }
    }
 
    @PostMapping("/edit")
    public Arrondissement doEdit(@Valid @RequestBody Arrondissement arrondissement) {
        try {
            this.adresseService.edit(arrondissement.getAdresse());
            return this.arrondissementService.edit(arrondissement);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
       
    @PostMapping("/delete")
    public Arrondissement doRemove(@Valid @RequestBody Arrondissement arrondissement) {
        try {
            this.arrondissementService.delete(arrondissement);
            adresseService.delete(arrondissement.getAdresse());
            return arrondissement;
        } catch (Exception e) {
            return null;
        }
    }

    
    public List<Arrondissement> setResponsableToString(List<Arrondissement> list) {
        for (Arrondissement arrondissement : list) {
            if(arrondissement.getResponsable() != null) {
              arrondissement.setIdUser(arrondissement.getResponsable().getUser().getNom() + " "+ arrondissement.getResponsable().getUser().getPrenom());  
            }else {
              arrondissement.setIdUser("Non défini");
            }
        }
        return list;
    }*/
    
}
