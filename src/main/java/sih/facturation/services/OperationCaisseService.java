package sih.facturation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.facturation.repositories.OperationCaisseRepository;

@Service
public class OperationCaisseService {
	@Autowired
	private OperationCaisseRepository repo;

}
