package sih.general.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.general.entities.DDS;

@Repository
public interface DDSRepo extends JpaRepository<DDS, Long> {
	

}
