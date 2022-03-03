package sih.compta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.compta.entities.Immo;

@Repository
public interface ImmoRepository extends JpaRepository<Immo, Long>{

}
