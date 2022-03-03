
package sih.general.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sih/general/espace/quartier")
@CrossOrigin("*") 
public class QuartierController {
   /* 
    @Autowired
    private final QuartierService quartierService;
    @Autowired
    private final AdresseService adresseService;
    @Autowired
    private final PersonneService personneService;

    public QuartierController(QuartierService quartierService, AdresseService adresseService, PersonneService personneService) {
        this.quartierService = quartierService;
        this.adresseService = adresseService;
        this.personneService = personneService;
    }

      
    
    @GetMapping("/list")
    public List<Quartier> list() {
        return  this.setNombreHabitant(this.quartierService.findAll());
    }
    
    @GetMapping("/sizeof-quartier")
    public int sizeOfArrondissment() {
        return  quartierService.sizeOfQuartier();
    }

    @GetMapping("/search/{id}")
    public Quartier findById(@PathVariable(value="id") String id) {
        try {
            return  quartierService.findById(id);
        } catch (Exception e) {
            return null;
        } 
    }
    
    @GetMapping("/search-by-arrondissement/{id}")
    public List<Quartier> findAllByArrondissement(@PathVariable(value="id") String id) {
        return  this.setNombreHabitant(this.quartierService.findAllByArrondissement(id));
    }
    
    @GetMapping("/search-by-commune/{id}")
    public List<Quartier> findAllByCommune(@PathVariable(value="id") String id) {
        return  this.setNombreHabitant(this.quartierService.findAllByCommune(id));
    }
    
    @GetMapping("/sizeof-quartier-com/{id}")
    public int sizeOfQuartierByCom(@PathVariable(value="id") String id) {
        return  this.quartierService.sizeOfQuartierByCom(id) ;
    }
    
    @GetMapping("/sizeof-quartier-arrond/{id}")
    public int sizeOfQuartierByArrond(@PathVariable(value="id") String id) {
        return  this.quartierService.sizeOfQuartierByArrond(id);
    }
    
    @PostMapping("/insert")
    public Quartier doCreate(@Valid @RequestBody Quartier quartier) {
        try {
            Adresse adresse = adresseService.save(quartier.getAdresse());
            quartier.setAdresse(adresse);
            return this.quartierService.save(quartier);
        } catch (Exception e) {
            return null;
        }
    }
 
    @PostMapping("/edit")
    public Quartier doEdit(@Valid @RequestBody Quartier quartier) {
        try {
            this.adresseService.edit(quartier.getAdresse());
            return this.quartierService.edit(quartier);
        } catch (Exception e) {
            return null;
        }
    }
    
       
    @PostMapping("/delete")
    public Quartier doRemove(@Valid @RequestBody Quartier quartier) {
        try {
            this.quartierService.delete(quartier);
            this.adresseService.delete(quartier.getAdresse());
            return quartier;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Quartier> setNombreHabitant(List<Quartier> list) {
        for (Quartier quartier : list) {
            quartier.setNombreHabitant(this.personneService.sizeOfByQuartier(quartier.getId()));
        }
        return list;
    }*/
}
