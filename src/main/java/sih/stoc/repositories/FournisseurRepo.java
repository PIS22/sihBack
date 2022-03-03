package sih.stoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sih.stoc.entities.Fournisseur;

public interface FournisseurRepo extends JpaRepository<Fournisseur, String> {

}
