package sih.facturation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sih.facturation.entities.OperationCaisse;

@Repository
public interface OperationCaisseRepository extends JpaRepository<OperationCaisse, String> {
	
	@Query(value = "SELECT * FROM operation_caisse WHERE exo_cod_exo=?", nativeQuery = true)
	public OperationCaisse dernier(int ex);

}
