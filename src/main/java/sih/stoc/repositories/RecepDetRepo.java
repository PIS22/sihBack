package sih.stoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.stoc.entities.ReceptionDet;

@Repository
public interface RecepDetRepo extends JpaRepository<ReceptionDet, String> {

}
