package sih.securite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.securite.entities.Agir;

@Repository
public interface AgirRepo extends JpaRepository<Agir, Long> {

}
