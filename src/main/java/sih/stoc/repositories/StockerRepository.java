package sih.stoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sih.stoc.entities.Stocker;

public interface StockerRepository extends JpaRepository<Stocker, String> {
	
	@Query(value="Select * from stocker where stocker.mag_cod_mag = ? And autorise=true ", nativeQuery = true)
	public List<Stocker> findByIdMag(String idmag);
	
	@Query(value="Select * from stocker where article_cod_art = ? And autorise=true ", nativeQuery = true)
	public List<Stocker> findByIdArt(String idart);

	@Query(value="Select * from Stocker where mag_cod_mag = ? and article_cod_art = ?", nativeQuery = true)
	public List<Stocker> findByMagArt(String idmag, String idart);

	@Query(value="Select * from stocker where id_stk=?", nativeQuery = true)
	public Stocker find(String id);

	@Query(value="SELECT mag_cod_mag, article_cod_art, (SUM(qte_stk*cump)+:pu*:qte)/(Sum(qte_stk)+:qte) From stocker "
			+ "WHERE mag_cod_mag=:mag AND article_cod_art=:art GROUP BY mag_cod_mag, article_cod_art", nativeQuery = true)
	public double newcump(@Param("art") String art, @Param("pu") double pu, @Param("qte") double qte, @Param("mag") String mag);
	
	
	

}
