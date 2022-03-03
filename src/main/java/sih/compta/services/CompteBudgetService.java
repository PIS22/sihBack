package sih.compta.services;

import org.springframework.stereotype.Service;

import sih.compta.entities.CompteBudget;
import sih.compta.repositories.CompteBudgetRepository;

import java.util.List;

@Service
public class CompteBudgetService {

    private final CompteBudgetRepository repo;

    public CompteBudgetService(CompteBudgetRepository repo) {
        this.repo = repo;
    }

    public List<CompteBudget> getAll(){
        return repo.findAll();
    }

    public CompteBudget getById(Long id) {
        return repo.findById(id).get();
    }

    public CompteBudget add(CompteBudget lBdg) {
        return repo.save(lBdg);
    }

    public CompteBudget edit(Long id, CompteBudget lBdg) {

        if(repo.existsById(id)) {
            CompteBudget entiter = repo.findById(id).get();
            entiter.setExo(lBdg.getExo());
            entiter.setAccord(lBdg.getAccord());
            entiter.setEngagement(lBdg.getEngagement());
            entiter.setProposition(lBdg.getProposition());
            entiter.setRealisation(lBdg.getRealisation());
            entiter.setTypBdg(lBdg.getTypBdg());
            entiter.setVote(lBdg.getVote());
            entiter.setCpte(lBdg.getCpte());

            return repo.save(entiter);
        }
        return null;
    }

    public boolean delete (Long id) {
        repo.deleteById(id);
        return !repo.existsById(id);
    }
}
