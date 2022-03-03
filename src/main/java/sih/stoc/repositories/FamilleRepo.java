package sih.stoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.stoc.entities.Famille;

@Repository

public interface FamilleRepo extends JpaRepository<Famille, String>
{
	
	List<Famille> findByCodFam(String codFam);
	List<Famille> findByLibFam(String libFam);

}
