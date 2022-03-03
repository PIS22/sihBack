package sih.compta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.compta.entities.Budget;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
}
