package sih.general.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.general.entities.TypeCentre;

@Repository
public interface TypeCentreRepo extends JpaRepository <TypeCentre, Long> {

}
