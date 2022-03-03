package sih.securite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.securite.entities.Utilisateur;

@Repository
public interface UtilisateurRepo extends JpaRepository<Utilisateur, Long>{
	
	//@Query(value = "SELECT * FROM Utilisateur WHERE login like ?", nativeQuery = true)
	public Utilisateur findByLogin(String login); 

}
