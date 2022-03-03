package sih.compta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sih.compta.entities.Compte;

import java.util.List;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {

    public Compte findByNumCpte(String num);
    //@Query(value="g?", nativeQuery=true)
    public List<Compte> findByTypCpte(String t);
    @Query(value="select * FROM compte WHERE num_cpte like ?", nativeQuery=true)
    public List<Compte> enfants(String nCpte);
}
