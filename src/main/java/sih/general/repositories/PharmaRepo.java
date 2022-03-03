package sih.general.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.general.entities.Pharmacie;

@Repository
public interface PharmaRepo extends JpaRepository<Pharmacie, Long> {

}
