package sih.stoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sih.stoc.entities.Article;

@Repository
public interface ArticleRepo extends JpaRepository<Article, String>{

	@Query(value = "SELECT * FROM article WHERE achetable=true AND famille in (Select DISTINCT familles_cod_fam FROM familles_autorisees WHERE magasin_cod_mag =? )", nativeQuery = true)
	public List<Article> achetablesParMag(String Mag);
	
	@Query(value = "SELECT * FROM article WHERE achetable=true", nativeQuery = true)
	public List<Article> achetables();

	@Query(value = "SELECT * FROM article WHERE ven_art=?", nativeQuery = true)
	public List<Article> vendable(boolean val);

	@Query(value = "SELECT * FROM article WHERE consommable=?", nativeQuery = true)
	public List<Article> consommable(boolean val);

}
