package sih.stoc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.stoc.entities.Client;
import sih.stoc.repositories.ClientRepo;


@Service
public class ClientService {
	
	@Autowired
	private  ClientRepo repo;
	
	public Client insert(Client elt) {
		return repo.save(elt);
	}
		// Modification
	public Client edit(Client elt) {
		return repo.save(elt);
	}
	
	public void delete(Long id) {
			repo.deleteById(id);
	}
	
	public List<Client> list(){
		return repo.findAll();
	}
	
	public Client select(Long id) {
		return repo.findById(id).get();
	}

}