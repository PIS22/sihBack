package sih.general.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.general.entities.ServicesSpecialises;

@Repository
public interface ServSpeRepo extends JpaRepository <ServicesSpecialises, Long> {

}
