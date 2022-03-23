package sih;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import sih.general.entities.Personne;
import sih.general.repositories.PersonnRepo;
import sih.securite.config.Audito;
import sih.securite.entities.AppRole;
import sih.securite.entities.Utilisateur;
import sih.securite.repositories.RoleRepo;
import sih.securite.repositories.UtilisateurService;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication// (exclude = SecurityFilterAutoConfiguration.class)
@EnableJpaAuditing(auditorAwareRef = "audito")
public class SihApplication implements CommandLineRunner {
	@Autowired
	UtilisateurService us;
	@Autowired
	PersonnRepo pers;
	@Autowired
	RoleRepo r;
	@Autowired
	BCryptPasswordEncoder bCrypt;
	public static void main(String[] args) {
		SpringApplication.run(SihApplication.class, args);
	}
	
	   @Bean
	   public Docket roomApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("sih.swaggerdemo")).build();
	   }
	
	@Bean
	public BCryptPasswordEncoder crypt() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuditorAware<String> audito(){
	
		return new Audito();
	}

	@Override
	public void run(String... args) throws Exception {	
		if(us.listUser().size()==0) {
			Personne p=new Personne("Administrateur", "Système", LocalDateTime.of(1900, 1, 1, 0, 0), "", "", "", "", "", "", "", "");
			List<AppRole> roles= new ArrayList<AppRole>();
			Utilisateur u= new Utilisateur("Admin", "admin", pers.save(p));
			roles.add(r.save(new AppRole("Stock")));
			roles.add(r.save(new AppRole("GRH")));
			roles.add(r.save(new AppRole("Hopital")));
			roles.add(r.save(new AppRole("Caisse")));
			u.setRoles(roles);
			us.insertUser(u);
		}
	}

}
