package sih.facturation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.facturation.entities.VenteDetail;

@Repository
public interface VenteDetailRepo extends JpaRepository<VenteDetail, Long> {

}