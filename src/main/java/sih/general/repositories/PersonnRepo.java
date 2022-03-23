package sih.general.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.general.entities.Personne;

@Repository
public interface PersonnRepo extends JpaRepository<Personne, Long> {

}
