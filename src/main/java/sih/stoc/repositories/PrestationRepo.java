package sih.stoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.stoc.entities.Prestation;

@Repository
public interface PrestationRepo extends JpaRepository<Prestation, String> {

}
