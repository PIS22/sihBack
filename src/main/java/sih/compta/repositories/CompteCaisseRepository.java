package sih.compta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.compta.entities.CompteCaisse;

@Repository
public interface CompteCaisseRepository extends JpaRepository<CompteCaisse, Long> {

}
