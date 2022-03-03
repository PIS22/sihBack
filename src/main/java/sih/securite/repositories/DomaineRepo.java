package sih.securite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.securite.entities.Domaine;

@Repository
public interface DomaineRepo extends JpaRepository<Domaine, Integer>{

}
