package sih.facturation.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import sih.facturation.entities.Vente;
import sih.facturation.entities.VenteDetail;

@Repository
public interface VenteRepo extends JpaRepository<Vente, String>{

	@Query(value = "SELECT * FROM vente WHERE exo_cod_exo=?", nativeQuery = true)
	public List<Vente> list(int exo);

	@Query(value = "SELECT * FROM vente WHERE date_vente between :deb And :fin AND "
			+ "caisse_cod_cai=:cai AND vendeur_id_user=:us;", nativeQuery = true)
	public List<Vente> ventePeriode(@Param("deb") LocalDateTime deb, @Param("fin") LocalDateTime fin, @Param("us") Long us, @Param("cai") String cai);

	@Query(value = "SELECT * FROM vente WHERE exo_cod_exo=? ORDER BY ordre DESC LIMIT 1", nativeQuery = true)
	public Vente dernier(int exo);
	
	

	@Query(value = "SELECT * FROM vente_detail WHERE id_vente=? ", nativeQuery = true)
	public List<VenteDetail> detailVente(String numVte);
	

}