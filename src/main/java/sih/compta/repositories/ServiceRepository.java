package sih.compta.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import sih.stoc.entities.Service;


@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
	
	//public List<Service> findByCodeService(String CodeService);
	
	//public List<Service> findByLibService(String LibelleService);

}
