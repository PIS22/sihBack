package sih.facturation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sih.facturation.entities.Caissier;

@Repository
public interface CaissierRepos extends JpaRepository<Caissier, Long> {
	
	@Query(value="SELECT caisse FROM caissier where caissier=1  and fin isNull", nativeQuery = true)
	public List<String> caissesActuelle(Long us);

}
