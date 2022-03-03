package sih.general.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.general.entities.Commune;

@Repository
public interface CommuneRepo extends JpaRepository<Commune, Long> {

}