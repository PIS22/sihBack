package sih.facturation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.facturation.entities.Caisse;


@Repository
public interface CaisseRepo extends JpaRepository<Caisse, String> {
	

}
