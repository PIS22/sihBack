package sih.general.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.general.entities.Exercice;

@Repository
public interface ExerciceRepo extends JpaRepository<Exercice, Integer> {
	public List<Exercice> findByEtaExo(String etat);

}
