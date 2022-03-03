package sih.stoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.stoc.entities.CommandeDet;

@Repository
public interface ComDetRepo extends JpaRepository<CommandeDet, String> {

}
