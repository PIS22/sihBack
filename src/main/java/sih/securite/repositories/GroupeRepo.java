package sih.securite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.securite.entities.Groupe;

@Repository
public interface GroupeRepo extends JpaRepository<Groupe, Integer>{

}
