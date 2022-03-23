package sih.stoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.stoc.entities.MouvementDetail;

@Repository
public interface MouvementDetailRepo extends JpaRepository<MouvementDetail, String> {

}
