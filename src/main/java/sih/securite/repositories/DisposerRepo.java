package sih.securite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.securite.entities.Disposer;

@Repository
public interface DisposerRepo extends JpaRepository<Disposer, Long> {
	

}
