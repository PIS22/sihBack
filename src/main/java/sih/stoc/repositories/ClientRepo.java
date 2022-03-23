package sih.stoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.stoc.entities.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long>{

}