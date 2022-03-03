package sih.general.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sih.general.entities.Arrondissement;

public interface ArrondissementRepository extends JpaRepository<Arrondissement, String> {
    @Query("select max(cast(substring(A.id, ?1) as integer)) from Arrondissement A where A.commune.id = ?2")
    public int findMaxId(int index, String idComm);
    
     // findAll order by date save
    @Query("from Arrondissement A order by A.dateSave desc")
    public List<Arrondissement> findAllDesc();
    // find all by commune
    @Query("from Arrondissement A where A.commune.id = ?1 order by A.code")
    public List<Arrondissement> findAllByCommune(String idCommune);
    
    /*/ find all by commune
    @Query("select A.description from Arrondissement A where A.commune.id = ?1 order by A.code")
    public List<String> findAllByCommuneLibelle(String idCommune);*/
    
    // find  by Id
    @Query("from Arrondissement A where A.id = ?1 ")
    public Arrondissement finddById(String idArrondissement);
        
    // count all arrondissement by commune
    @Query("select count(*) from Arrondissement A where A.commune.id = ?1")
    public int sizeOfArrondissmentByCom(String idCom);
    
    @Query("select count(*) from Arrondissement A")
    public int sizeOfArrondissment();
    
    
    
}
