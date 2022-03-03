package sih;

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

import sih.securite.config.Audito;
import sih.securite.entities.AppRole;
import sih.securite.entities.Domaine;
import sih.securite.entities.Objet;
import sih.securite.entities.Utilisateur;
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
			Utilisateur u=new Utilisateur();			/*us.insertObjet(u.structure());*/
			try {
				us.insertObjet(new Objet("Groupe", "idGpe; libGpe; desGpe"));
				us.insertObjet(new Objet("Droit", "idDrt; libDrt"));
				us.insertObjet(new Objet("AppRole", "idRole; nomRole"));
				us.insertObjet(new Objet("Disposer", "idDis; ajout; deb; fin; Obj; "));
			} catch (Exception e) {
				// TODO: handle exception
			}
			//Exercice e=new Exercice();			us.insertObjet(new Objet("Exercice", e.structure()));
			/*Disposer d=new Disposer();			us.insertObjet(d.structure());
			UserGroup ug=new UserGroup();			us.insertObjet(ug.structure());
			Compte c=new Compte();			us.insertObjet(c.structure());
			Activite a=new Activite();			us.insertObjet(a.structure());
			Budget b=new Budget();			us.insertObjet(b.structure());
			Article art=new Article();			us.insertObjet(art.structure());
			Caisse cai=new Caisse();			us.insertObjet(cai.structure());
			CompteArticle ca=new CompteArticle();			us.insertObjet(ca.structure());
			CompteBudget cb=new CompteBudget();			us.insertObjet(cb.structure());
			AppRole ar=new AppRole();			us.insertObjet(ar.structure());
			CompteEcriture ce=new CompteEcriture();			us.insertObjet(ce.structure());
			CompteCaisse cc=new CompteCaisse();			us.insertObjet(cc.structure());
			Ecriture e=new Ecriture();			us.insertObjet(e.structure());
			EtatImmo ei=new EtatImmo();			us.insertObjet(ei.structure());
			Immo i=new Immo();			us.insertObjet(i.structure());
			Journal j=new Journal();			us.insertObjet(j.structure());
			Localisation l=new Localisation();			us.insertObjet(l.structure());
			ModePaiement mp=new ModePaiement();			us.insertObjet(mp.structure());
			NatureJournal nj=new NatureJournal();			us.insertObjet(nj.structure());
			TypeAmort ta=new TypeAmort();			us.insertObjet(ta.structure());
			TypeBudget tb=new TypeBudget();			us.insertObjet(tb.structure());*/
			List<Objet> ent= new ArrayList<Objet>();
			ent.add(us.selectObjet("Utilisateur"));
			ent.add(us.selectObjet("Group"));
			ent.add(us.selectObjet("UserGroup"));
			ent.add(us.selectObjet("Disposer"));
			us.insertDom(new Domaine("Sécurité", ent));

			/*ent= new ArrayList<>();
			ent.add(us.selectObjet("Utilisateur"));
			ent.add(us.selectObjet("Group"));
			ent.add(us.selectObjet("UserGroup"));
			ent.add(us.selectObjet("Disposer"));
			us.insertDom(new Domaine("Stock", ent));

			ent= new ArrayList<>();
			ent.add(us.selectObjet("Utilisateur"));
			ent.add(us.selectObjet("Group"));
			ent.add(us.selectObjet("UserGroup"));
			ent.add(us.selectObjet("Disposer"));
			us.insertDom(new Domaine("Facturation", ent));

			ent= new ArrayList<>();
			ent.add(us.selectObjet("Utilisateur"));
			ent.add(us.selectObjet("Group"));
			ent.add(us.selectObjet("UserGroup"));
			ent.add(us.selectObjet("Disposer"));
			us.insertDom(new Domaine("Personnel", ent));
			
			ent= new ArrayList<>();
			ent.add(us.selectObjet("Utilisateur"));
			ent.add(us.selectObjet("Group"));
			ent.add(us.selectObjet("UserGroup"));
			ent.add(us.selectObjet("Disposer"));
			us.insertDom(new Domaine("Facturation", ent));
			
			ent =new ArrayList<>();
			ent.add(us.selectObjet("Activite"));
			ent.add(us.selectObjet("Budget"));
			ent.add(us.selectObjet("Compte"));
			ent.add(us.selectObjet("CompteArticle"));
			ent.add(us.selectObjet("CompteBudget"));
			ent.add(us.selectObjet("CompteCaisse"));
			ent.add(us.selectObjet("CompteEcriture"));
			ent.add(us.selectObjet("Ecriture"));
			ent.add(us.selectObjet("EtatImmo"));
			us.insertDom(new Domaine("Comptabilite", ent));*/
			try {
			us.insertRole(new AppRole("Admin"));
			us.insertRole(new AppRole("Comptable"));
			us.insertRole(new AppRole("Stock"));
			us.insertRole(new AppRole("Personnel"));
			us.insertRole(new AppRole("Facturation"));
			u= new Utilisateur("User1","user");
			//System.out.println(us.findByNomRole("Stock"));
			us.insertUser(u);
			us.affectRoleToUser(u, us.findByNomRole("Stock"));
			us.affectRoleToUser(u, us.findByNomRole("Comptable"));
			us.affectRoleToUser(u, us.findByNomRole("Facturation"));
			us.affectRoleToUser(u, us.findByNomRole("Personnel"));
			
			
			Utilisateur ut=new Utilisateur("Admin", "admin");
			us.insertUser(ut);
			us.listRole().forEach(r->{
				us.affectRoleToUser(ut, r);
			});
			
			
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}
