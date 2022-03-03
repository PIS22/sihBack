
package sih.general.services;

import java.util.List;
import org.springframework.stereotype.Service;

import sih.general.entities.Arrondissement;
import sih.general.repositories.ArrondissementRepository;

@Service
public class ArrondissementService {
    
    private final ArrondissementRepository arrondissementRepository;

    public ArrondissementService(ArrondissementRepository arrondissementRepository) {
        this.arrondissementRepository = arrondissementRepository;
    }
    
    // Liste des arrondissements
    public List<Arrondissement> findAll() {
        return this.arrondissementRepository.findAllDesc();
    }
    
    public int sizeOfArrondissment() {
        try {
            return this.arrondissementRepository.sizeOfArrondissment();
        } catch (Exception e) {
            return 0;
        }
    }
    
     // Liste des arrondissements par commune
    public List<Arrondissement> findAllByCommune(String idCommune) {
        return this.arrondissementRepository.findAllByCommune(idCommune);
    }
    
    public void findAllByCommuneLibelle(String idCommune) {
       // return this.arrondissementRepository.findAllByCommuneLibelle(idCommune);
    }
    
    public int sizeOfArrondissmentByCom(String idCom) {
        try {
            return this.arrondissementRepository.sizeOfArrondissmentByCom(idCom);
        } catch (Exception e) {
            return 0;
        }
    }
    // Renvoie un arrondissement par son id
    
    public Arrondissement findById(String id) {
        return this.arrondissementRepository.finddById(id);
    }
    
    // Sauvegarder un arrondissement
    public Arrondissement save(Arrondissement arrondissement) {
        //arrondissement.setId(getId(arrondissement.getCommune().getId()));
        return this.arrondissementRepository.save(arrondissement);
    }
    
    public Arrondissement edit(Arrondissement arrondissement) {
        return this.arrondissementRepository.save(arrondissement);
    }
    
    
    // Supprimer un arrondissement
    
    public void delete(Arrondissement arrondissement) {
        this.arrondissementRepository.delete(arrondissement);
    } 
    
    public int findMaxId(int index, String idCom) {
        try {
            return this.arrondissementRepository.findMaxId(index,idCom);
        } catch (Exception e) {
            return 0;
        }
    }
    
    /*public String getId(String idCom) {
        String indicatif = idCom + Constantes.INDICATIF_ARRONDISSEMENT;
        int indexNext = findMaxId(indicatif.length() +1, idCom)+ 1;             
        return indicatif + indexNext;
    }*/
    
}
