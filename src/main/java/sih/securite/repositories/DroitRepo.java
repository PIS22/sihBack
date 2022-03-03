package sih.securite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.securite.entities.Droit;

@Repository
public interface DroitRepo extends JpaRepository<Droit, Long> {

}
