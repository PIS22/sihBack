package sih.compta.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.compta.entities.TypeBudget;

@Repository
public interface TypBdgRepository extends JpaRepository<TypeBudget, Long> {
}
