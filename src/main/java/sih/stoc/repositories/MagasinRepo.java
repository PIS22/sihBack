package sih.stoc.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sih.stoc.entities.Magasin;


public interface MagasinRepo extends JpaRepository<Magasin, String>{
	
	public Magasin findByCodMag(String codMag);
	
	@Query(value = "SELECT familles_cod_fam FROM familles_autorisees WHERE magasin_cod_mag = ? ", nativeQuery = true)
	public List<String> familleParMagasin(String mag);
	
	@Query(value = "SELECT * FROM stocker WHERE magasin_cod_mag = ? ", nativeQuery = true)
	public List<Long> stockParMagasin(String mag);
	
}
