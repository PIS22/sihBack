package sih.compta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.compta.entities.CompteBudget;

@Repository
public interface CompteBudgetRepository extends JpaRepository<CompteBudget, Long> {
}
