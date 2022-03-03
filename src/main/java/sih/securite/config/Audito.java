package sih.securite.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class Audito implements AuditorAware<String> {
	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("Admin").filter(s->!s.isEmpty());
	}

}
