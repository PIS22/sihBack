package sih.compta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.compta.entities.Localisation;

@Repository
public interface LocalisationRepository extends JpaRepository<Localisation, Long>{

}
