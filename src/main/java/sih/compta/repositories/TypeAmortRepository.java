package sih.compta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.compta.entities.TypeAmort;


@Repository
public interface TypeAmortRepository extends JpaRepository<TypeAmort, Long> {

}
