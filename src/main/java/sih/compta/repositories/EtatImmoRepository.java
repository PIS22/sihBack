package sih.compta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.compta.entities.EtatImmo;

@Repository
public interface EtatImmoRepository extends JpaRepository<EtatImmo, Long> {

}
