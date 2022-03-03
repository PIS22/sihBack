package sih.securite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.securite.entities.AppRole;
@Repository
public interface RoleRepo extends JpaRepository<AppRole, Integer> {
	//@Query(value="SELECT * FROM AppRole R WHERE R.nomRole like ?", nativeQuery = true)
	public AppRole findByNomRole(String nomRole);
}
