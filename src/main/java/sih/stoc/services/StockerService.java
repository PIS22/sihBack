package sih.stoc.services;

import org.springframework.beans.factory.annotation.Autowired;

import sih.stoc.repositories.StockerRepository;

public class StockerService {
	@Autowired
	StockerRepository str;
}
