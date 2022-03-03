package sih.stoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sih.stoc.entities.ExpressionDetail;

@Repository
public interface LigneEBRepo extends JpaRepository<ExpressionDetail, Long>{
	@Query(value="Select * From ligneeb WHERE eb_numeb like ?", nativeQuery = true)
	public List<ExpressionDetail> lineByEb(String numeb);

}
