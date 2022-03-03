package sih.compta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sih.compta.entities.CompteEcriture;

import java.util.List;

@Repository
public interface CompteEcritureRepository extends JpaRepository<CompteEcriture, Long> {

    @Query(value = "SELECT * FROM ligne_ecriture WHERE num_ecri = ? ", nativeQuery = true)
    public List<CompteEcriture> linesOf(String num);

}
