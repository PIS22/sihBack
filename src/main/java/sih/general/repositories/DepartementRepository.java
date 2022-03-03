package sih.general.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sih.general.entities.Departement;
import sih.general.entities.Pays;
public interface DepartementRepository extends JpaRepository<Departement, String> {

	public List<Departement> findByCodeDepartement(String codeDepartement);
	
	public List<Departement> findByNomDepartement(String nomDepartement);
	
	public List<Departement> findByPays(Pays pays);
	
}
