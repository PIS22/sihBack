package sih.stoc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sih.stoc.entities.CommandeDetail;

@Repository
public interface ComDetRepo extends JpaRepository<CommandeDetail, String> {
	@Query(value="SELECT * FROM commande_detail WHERE com_num_com like ?", nativeQuery = true)
	public List<CommandeDetail> detailByCom(String num);

}
