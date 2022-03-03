package sih.securite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sih.securite.entities.Objet;

@Repository
public interface ObjetRepo extends JpaRepository<Objet, String> {
	@Query(value = "SELECT * FROM Objet WHERE lib_obj LIKE ?", nativeQuery = true)
	public Objet objetByLib(String lib);
}
