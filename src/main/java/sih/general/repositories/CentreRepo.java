package sih.general.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.general.entities.Centre;

@Repository
public interface CentreRepo extends JpaRepository<Centre, Long> {

}