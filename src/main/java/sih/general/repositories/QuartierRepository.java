
package sih.general.repositories;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sih.general.entities.Quartier;


public interface QuartierRepository extends JpaRepository<Quartier, String>{
    @Query("select max(cast(substring(Q.id, ?1) as integer)) from Quartier Q where Q.arrondissement.id = ?2")
    public int findMaxId(int index, String idArr);    
    // find  by Id
    @Query("from Quartier Q where Q.id = ?1 ")
    public Quartier finddById(String idQuartier);
     // find all by Arrondissement
    @Query("from Quartier Q order by Q.dateSave desc ")
    public List<Quartier> findAll1();
     // find all by Arrondissement
    @Query("from Quartier Q where Q.arrondissement.id = ?1 ")
    public List<Quartier> findAllByArrondissement(String idArrondissement);
    @Query("from Quartier Q where Q.arrondissement.commune.id = ?1 ")
    public List<Quartier> findAllByCommune(String idCom);
    @Query("select Q.description from Quartier Q where Q.arrondissement.id = ?1 ")
    public List<String> findAllByArrondissementLibelle(String idArrondissement);
    // count all quartier by commune
    @Query("select count(*) from Quartier Q where Q.arrondissement.commune.id = ?1")
    public int sizeOfQuartierByCom(String idCom);
    
    // count all quartier by arrondissement
    @Query("select count(*) from Quartier Q where Q.arrondissement.id = ?1")
    public int sizeOfQuartierByArrond(String idArrond);
    @Query("select count(*) from Quartier Q")
    public int sizeOfQuartier();
    
}
