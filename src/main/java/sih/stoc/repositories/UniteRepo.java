package sih.stoc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sih.stoc.entities.Unite;

public interface UniteRepo extends JpaRepository<Unite, String>{
	public Unite findByCodUnit(String codUnit);

}
