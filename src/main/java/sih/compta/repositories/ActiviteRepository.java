package sih.compta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.compta.entities.Activite;
@Repository
public interface ActiviteRepository extends JpaRepository<Activite, Long > {

}
