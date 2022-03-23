package sih.stoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sih.stoc.entities.Mouvement;

@Repository
public interface MouvementRepo extends JpaRepository<Mouvement, String> {

	@Query(value = "SELECT * FROM movement WHERE exo_cod_exo=?", nativeQuery = true)
	public List<Mouvement> list(int exo);

	@Query(value = "SELECT * FROM mouvement WHERE exo_cod_exo=? ORDER BY ordre DESC LIMIT 1", nativeQuery = true)
	public Mouvement dernier(int exo);

}
