package sih.stoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sih.stoc.entities.Commande;
import sih.stoc.entities.CommandeDet;

public interface CommandeRepo extends JpaRepository<Commande, String> {
	
	@Query(value = "DELETE FROM commande_det WHERE com_num_com like ?; ", nativeQuery = true)
	public void suppDetailCom(String num);
	
	@Query(value = "SELECT * FROM commande WHERE exo_cod_exo = ?;", nativeQuery = true)
	public List<Commande> list(int exo);
	
	@Query(value = "SELECT * FROM commande_det WHERE com_num_com like ?;", nativeQuery = true)
	public List<CommandeDet> detailCommande(String num);

	@Query(value = "SELECT c.* FROM commande c where c.valide=true AND c.active=true;", nativeQuery = true)
	public List<Commande> commandeEligibles();

	@Query(value = "SELECT ordre FROM commande c WHERE c.exo_cod_exo = ? ORDER BY c.ordre DESC;", nativeQuery = true)
	public int dernier(int cod);
	
	
	

}
