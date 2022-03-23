package sih.stoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sih.stoc.entities.Commande;
import sih.stoc.entities.CommandeDetail;

public interface CommandeRepo extends JpaRepository<Commande, String> {
	
	@Query(value = "DELETE FROM commande_det WHERE com_num_com like ?; ", nativeQuery = true)
	public void suppDetailCom(String num);
	
	@Query(value = "SELECT * FROM commande WHERE exo_cod_exo = ?;", nativeQuery = true)
	public List<Commande> list(int exo);

	@Query(value = "SELECT c.* FROM commande c where c.valide=true AND c.active=true;", nativeQuery = true)
	public List<Commande> commandeEligibles();

	@Query(value = "SELECT * FROM commande c WHERE c.exo_cod_exo = ? ORDER BY c.ordre DESC Limit 1;", nativeQuery = true)
	public Commande dernier(int cod);

	@Query(value = "SELECT * FROM commande_detail c WHERE c.qte_liv>0 AND com_num_com = ?;", nativeQuery = true)
	public List<CommandeDetail> livraison(String com);
	
	
	

}
