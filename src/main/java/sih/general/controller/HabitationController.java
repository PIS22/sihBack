
package sih.general.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sih/genral/espace/habitation")
@CrossOrigin("*")  
public class HabitationController {
 /*   
    @Autowired
    private final HabitationService habitationService;
    @Autowired
    private final ArrondissementService arrondissementService;
    @Autowired
    private final QuartierService quartierService;
    @Autowired
    private final CommuneService communeService;
    @Autowired
    private final UserService userService;
    @Autowired
    private final JournalService journalService;
    @Autowired
    private final SecteurService secteurService;
    @Autowired
    private final CategorieService categorieService;

    public HabitationController(HabitationService habitationService, ArrondissementService arrondissementService, QuartierService quartierService, CommuneService communeService, UserService userService, JournalService journalService, SecteurService secteurService, CategorieService categorieService) {
        this.habitationService = habitationService;
        this.arrondissementService = arrondissementService;
        this.quartierService = quartierService;
        this.communeService = communeService;
        this.userService = userService;
        this.journalService = journalService;
        this.secteurService = secteurService;
        this.categorieService = categorieService;
    }

    @GetMapping("/list")
    public List<Habitation> list() {
        return  this.habitationService.findAll();
    }
    
    @GetMapping("/search-by-com/{id}")
    public List<Habitation> findByCommune(@PathVariable(value="id") String id) {
        try {
            return  habitationService.findAllByCommune(id);
        } catch (Exception e) {
            return null;
        } 
    }
    
    // Chart bar 
    @GetMapping("/stat-all-params1/{id}")
    public DataChartThreeLineExport findDataChartBarByInfra1(@PathVariable(value="id") String id) {
        String [] tab = id.split("_");
        String idLieuTravail = tab[0];
        DataChartThreeLineExport dataChartThreeLineExport = null;
        if(tab.length == 3 ) {
            // Commune
            if(tab[2].equals(Constantes.NULL)) {
                List<String> abscisses = this.arrondissementService.findAllByCommuneLibelle(tab[0]);
                List<Arrondissement> arrondissements = this.arrondissementService.findAllByCommune(tab[0]);
                dataChartThreeLineExport = new DataChartThreeLineExport(getDataBarChartFormatArrond(Integer.parseInt(tab[1]), arrondissements),abscisses);
            }else {
                List<String> abscisses = this.quartierService.findAllByArrondissementLibelle(tab[2]);
                List<Quartier> quartiers = this.quartierService.findAllByArrondissement(tab[2]);
                dataChartThreeLineExport = new DataChartThreeLineExport(getDataBarChartFormatQuartier(Integer.parseInt(tab[1]), quartiers),abscisses);
            }
        } else {
           // Arrondissement
                List<String> abscisses = this.quartierService.findAllByArrondissementLibelle(idLieuTravail.split("-")[1]);
                List<Quartier> quartiers = this.quartierService.findAllByArrondissement(idLieuTravail.split("-")[1]);
                dataChartThreeLineExport = new DataChartThreeLineExport(getDataBarChartFormatQuartier(Integer.parseInt(tab[1]), quartiers),abscisses);
        }
      return dataChartThreeLineExport;
    }
    
    // Chart bar 
    @GetMapping("/stat-all-params/{id}")
    public DataChartThreeLineExport findDataChartBarByInfra(@PathVariable(value = "id") String id) {
        DataChartThreeLineExport dataChartThreeLineExport = null;
        String[] tab = id.split("_");        
        int minYear = 0 ; //Integer.parseInt(tab[1].split("-")[0]);
        int maxYear = 25; //Integer.parseInt(tab[1].split("-")[1]);
        if(tab.length == 3) { // Arrondissement
           List<String> abscisses = this.quartierService.findAllByArrondissementLibelle(tab[0]);
           List<Quartier> quartiers = this.quartierService.findAllByArrondissement(tab[0]);
           dataChartThreeLineExport = new DataChartThreeLineExport(getDataBarChartFormatQuartier(Integer.parseInt(tab[1]), quartiers),abscisses);
           if(tab[2] == "PLOT") {
            Arrondissement arrond = this.arrondissementService.findById(tab[0]);
            String lienFile = Utils.plot(arrond.getCommune(), arrond, dataChartThreeLineExport, maxYear, minYear, "Répartition de la population par tranche d'âges", "Quartier", "Population", "NULL");
            dataChartThreeLineExport.setUrlFile(lienFile+".pdf");
           }
        }else { // Commune
            Commune com = this.communeService.findById(tab[0]);
           if(tab[2].equals("NULL") ) {
               List<String> abscisses = this.arrondissementService.findAllByCommuneLibelle(tab[0]);
               List<Arrondissement> arrondissements = this.arrondissementService.findAllByCommune(tab[0]);
               dataChartThreeLineExport = new DataChartThreeLineExport(getDataBarChartFormatArrond(Integer.parseInt(tab[1]), arrondissements),abscisses);
               if(tab[3].equals("PLOT")) {
                   String lienFile = Utils.plot(com, null, dataChartThreeLineExport, maxYear, minYear, "Répartition de la population par tranche d'âges", "Arrondissement", "Population", "NULL");
                   dataChartThreeLineExport.setUrlFile(lienFile + ".pdf");
               } 
           }else {
               List<String> abscisses = this.quartierService.findAllByArrondissementLibelle(tab[2]);
               List<Quartier> quartiers = this.quartierService.findAllByArrondissement(tab[2]);
               Arrondissement arrond = this.arrondissementService.findById(tab[2]);
               dataChartThreeLineExport = new DataChartThreeLineExport(getDataBarChartFormatQuartier(Integer.parseInt(tab[1]), quartiers),abscisses);
               if(tab[3].equals("PLOT")) {
                   String lienFile = Utils.plot(com, null, dataChartThreeLineExport, maxYear, minYear, "Répartition de la population par tranche d'âges", "Quartier", "Population", arrond.getDescription());
                   dataChartThreeLineExport.setUrlFile(lienFile + ".pdf");
               }   
           }   
        }
        return dataChartThreeLineExport;
    }
    
    
    
    @GetMapping("/search-all/{id}")
    public List<Habitation> findAllMultipleParams(@PathVariable(value="id") String id) {
        List<Habitation> habitations = null;
        String [] tab = id.split("_");
        if(tab.length == 3) {
            String idArr = tab[0].split("-")[1];
            // Arrondissement
            if(!tab[1].equals(Constantes.NULL) && !tab[2].equals(Constantes.NULL)) {
                // secteur & quartier
                habitations = this.habitationService.findAllBySecteurByQuartier(Integer.parseInt(tab[1]), tab[2]);
            }
            if(tab[1].equals(Constantes.NULL) && !tab[2].equals(Constantes.NULL)) {
                // quartier
                habitations = this.habitationService.findAllByQuartier(tab[2]);
            }
            if(tab[1].equals(Constantes.NULL) && tab[2].equals(Constantes.NULL)) {
                // Arrond
                habitations = this.habitationService.findAllByArrond(idArr);
            }
            if(!tab[1].equals(Constantes.NULL) && tab[2].equals(Constantes.NULL)) {
                // secteur & arrond
                habitations = this.habitationService.findAllBySecteurByArrond(Integer.parseInt(tab[1]), idArr);
            }
        }else {
            // Commune
            String idCom = tab[0].split("-")[0];
            if(!tab[1].equals(Constantes.NULL) && !tab[2].equals(Constantes.NULL) && !tab[3].equals(Constantes.NULL)) {
                // secteur & arrond
                habitations = this.habitationService.findAllBySecteurByQuartier(Integer.parseInt(tab[1]), tab[3]);
            }
            if(!tab[1].equals(Constantes.NULL) && tab[2].equals(Constantes.NULL)) {
                // secteur & arrond
                habitations = this.habitationService.findAllBySecteurByCom(Integer.parseInt(tab[1]), idCom);
            }
            if(!tab[1].equals(Constantes.NULL) && !tab[2].equals(Constantes.NULL) && tab[3].equals(Constantes.NULL)) {
                // secteur & arrond
                habitations = this.habitationService.findAllBySecteurByArrond(Integer.parseInt(tab[1]), tab[2]);
            }
            if(tab[1].equals(Constantes.NULL) && !tab[2].equals(Constantes.NULL) && tab[3].equals(Constantes.NULL)) {
                // secteur & arrond
                habitations = this.habitationService.findAllByArrond(tab[2]);
            }
            if(tab[1].equals(Constantes.NULL) && !tab[2].equals(Constantes.NULL) && !tab[3].equals(Constantes.NULL)) {
                // secteur & arrond
                habitations = this.habitationService.findAllByQuartier(tab[3]);
            }
        }
        
        return habitations; 
    }
    
    @GetMapping("/search-by-arrond/{id}")
    public List<Habitation> findAllByArrond(@PathVariable(value="id") String id) {
        try {
            return  habitationService.findAllByArrond(id);
        } catch (Exception e) {
            return null;
        } 
    }
    
    @GetMapping("/search-by-quartier/{id}")
    public List<Habitation> findAllByQuartier(@PathVariable(value="id") String id) {
        try {
            return  habitationService.findAllByQuartier(id);
        } catch (Exception e) {
            return null;
        } 
    }
    
   // findAllBySecteurByComLib
    
    @GetMapping("/search-by-secteur/{id}")
    public List<Habitation> findAllBySecteurLib(@PathVariable(value="id") String id) {
        try {
             String [] tab = id.split("-");
             if(tab.length == 2) {
                 return this.habitationService.findAllBySecteurByComLib(tab[1], tab[0]);
             }
             return this.habitationService.findAllBySecteurByArrondLib(tab[2], tab[1]);            
        } catch (Exception e) {
            return null;
        } 
    }
    
    @GetMapping("/search/{id}")
    public Habitation findById(@PathVariable(value="id") String id) {
        try {
            return  habitationService.findById(id);
        } catch (Exception e) {
            return null;
        } 
    }
    
    @PostMapping("/insert")
    public Habitation doCreate(@Valid @RequestBody Habitation habitation) {
        try {
            return this.habitationService.save(habitation);
        } catch (Exception e) {
            return null;
        }
    }
 
    @PostMapping("/edit")
    public Habitation doEdit(@Valid @RequestBody Habitation habitation) {
        try {
            return this.habitationService.edit(habitation);
        } catch (Exception e) {
            return null;
        }
    }
    
       
    @DeleteMapping("/delete/{id}")
    public Habitation doRemove(@PathVariable(value="id") String id) {
        try {
            Habitation habitation = habitationService.findById(id);
            this.habitationService.delete(habitation);
            return habitation;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<DataLineFormat> getDataBarChartFormatArrond(int idSecteur, List<Arrondissement> arrondissements) {
        List<DataLineFormat> dataLineFormats = new ArrayList<>();
        List<Categorie> categories = this.categorieService.findAllBySecteur(idSecteur);
       // List<Integer> tab = new ArrayList<>(); 
       // List<PlotDataChart> plotDataCharts = new ArrayList<>();
        List<DataChart1> dataCharts1 = new ArrayList<>();
        // List<DataChart>  dataCharts = null;         
        for (Categorie categorie : categories) {
            List<Integer> integers = new ArrayList<>();
            for (Arrondissement arrondissement : arrondissements) {
                int nombre = this.habitationService.sizeOfByCategorieByArrrond(categorie.getId(), arrondissement.getId());
                integers.add(nombre);
            }
            dataCharts1.add(new DataChart1(categorie.getDescriptionCourte(), integers));
        }
        for (DataChart1 dataChart1 : dataCharts1) {
            dataLineFormats.add(new DataLineFormat(dataChart1.getValues(), dataChart1.getLabel(), Utils.sommeElements(dataChart1.getValues())));
        }
        return dataLineFormats;
    }
    
    public List<DataLineFormat> getDataBarChartFormatQuartier(int idSecteur, List<Quartier> quartiers) {
        List<DataLineFormat> dataLineFormats = new ArrayList<>();
        List<Categorie> categories = this.categorieService.findAllBySecteur(idSecteur);
       // List<Integer> tab = new ArrayList<>(); 
       // List<PlotDataChart> plotDataCharts = new ArrayList<>();
        List<DataChart1> dataCharts1 = new ArrayList<>();
        // List<DataChart>  dataCharts = null;         
        for (Categorie categorie : categories) {
            List<Integer> integers = new ArrayList<>();
            for (Quartier quartier : quartiers) {
                int nombre = this.habitationService.sizeOfByCategorieByQutier(categorie.getId(), quartier.getId());
                integers.add(nombre);
            }
            dataCharts1.add(new DataChart1(categorie.getDescriptionCourte(), integers));
        }
        for (DataChart1 dataChart1 : dataCharts1) {
            dataLineFormats.add(new DataLineFormat(dataChart1.getValues(), dataChart1.getLabel(), Utils.sommeElements(dataChart1.getValues())));
        }
        return dataLineFormats;
    }
   
    
*/    
}
