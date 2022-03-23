package sih.securite.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;


import sih.securite.repositories.UtilisateurRepo;

public class Audito implements AuditorAware<String> {
	@Autowired
	UtilisateurRepo us;
	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.ofNullable(("Admin"));
	}

}
