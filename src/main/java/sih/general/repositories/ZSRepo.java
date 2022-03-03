package sih.general.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.general.entities.ZoneSanitaire;

@Repository
public interface ZSRepo extends JpaRepository  <ZoneSanitaire, Long>{

}
