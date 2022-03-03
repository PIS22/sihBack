package sih.stoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sih.stoc.entities.Stocker;

public interface StockerRepository extends JpaRepository<Stocker, Long> {
	
	@Query(value="Select * from Stocker where stocker.mag_id_mag = ? ", nativeQuery = true)
	public List<Stocker> findByIdMag(String idmag);
	
	@Query(value="Select * from Stocker where stocker.article_id_art = ? ", nativeQuery = true)
	public List<Stocker> findByIdArt(String idart);
	
	@Query(value="Select * from Stocker where stocker.id_mag = ? and stocker.id_art = ? ", nativeQuery = true)
	public List<Stocker> findByMagArt(Long idmag, Long idart);
	
	

}
