package sih.compta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sih.compta.entities.CompteArticle;

@Repository
public interface CompteArticleRepository extends JpaRepository<CompteArticle, Long> {

	
	
}
