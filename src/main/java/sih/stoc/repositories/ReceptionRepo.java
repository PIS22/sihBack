package sih.stoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.stoc.entities.Reception;

@Repository
public interface ReceptionRepo extends JpaRepository<Reception, String> {

}
