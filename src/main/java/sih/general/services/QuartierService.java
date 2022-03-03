
package sih.general.services;


import java.util.List;
import org.springframework.stereotype.Service;

import sih.general.entities.Quartier;
import sih.general.repositories.QuartierRepository;

@Service
public class QuartierService {
    // @Autowired
    private final QuartierRepository quartierRepository;

    public QuartierService(QuartierRepository quartierRepository) {
        this.quartierRepository = quartierRepository;
    }

    // Liste des quartier
    public List<Quartier> findAll() {
        return  this.quartierRepository.findAll1();
    }
    
    public int sizeOfQuartier() {
        return this.quartierRepository.sizeOfQuartier();
    }
    
    // Liste des quartier selon l'arrondissement
    public List<Quartier> findAllByArrondissement(String idArrondissement) {
        return  this.quartierRepository.findAllByArrondissement(idArrondissement);
    }
    
    // Renvoie une quartier par son id    
    public Quartier findById(String id) {
        return this.quartierRepository.finddById(id);
    }
    
    // Sauvegarder une quartier
    public Quartier save(Quartier quartier) {
    //    quartier.setId(getId(quartier.getArrondissement().getId()));
        return this.quartierRepository.save(quartier);
    }
    
    // Editer une quartier
    public Quartier edit(Quartier quartier) {
        return this.quartierRepository.save(quartier);
    }
    
    // Supprimer une quartier
    public void delete(Quartier quartier) {
         this.quartierRepository.delete(quartier);
    }  
    
    public int sizeOfQuartierByCom(String idCom) {
        return this.quartierRepository.sizeOfQuartierByCom(idCom);
    }
    
    public int sizeOfQuartierByArrond(String idArrond) {
        return this.quartierRepository.sizeOfQuartierByArrond(idArrond);
    }
    
    public List<String> findAllByArrondissementLibelle(String idArrondissement) {
        return this.quartierRepository.findAllByArrondissementLibelle(idArrondissement);
    }
    
    public List<Quartier> findAllByCommune(String idCom) {
        return this.quartierRepository.findAllByCommune(idCom);
    }
    
    public int findMaxId(int index, String idCom) {
        try {
            return this.quartierRepository.findMaxId(index,idCom);
        } catch (Exception e) {
            return 0;
        }
    }
    
    /*public String getId(String idArr) {
        String indicatif = idArr + Constantes.INDICATIF_QUARTIER;
        int indexNext = findMaxId(indicatif.length() +1, idArr)+ 1;             
        return indicatif + indexNext;
    }*/
}
