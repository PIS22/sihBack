package sih.general.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import sih.securite.config.Audit;
import sih.securite.entities.Utilisateur;
@SuppressWarnings("serial")
@Entity
@EnableJpaAuditing
public class Exercice extends Audit<Utilisateur> implements Serializable {
	@Id
	private int codExo;
	private String libExo;
	private LocalDateTime debExo;
	private LocalDateTime finExo;
	private String etaExo;
	
	public Exercice() {
		// TODO Auto-generated constructor stub
	}

	public Exercice(int codExo, String libExo, LocalDateTime debExo, LocalDateTime finExo, String etaExo) {
		super();
		this.codExo = codExo;
		this.libExo = libExo;
		this.debExo = debExo;
		this.finExo = finExo;
		this.etaExo = etaExo;
	}

	public int getCodExo() {
		return codExo;
	}

	public void setCodExo(int codExo) {
		this.codExo = codExo;
	}

	public String getLibExo() {
		return libExo;
	}

	public void setLibExo(String libExo) {
		this.libExo = libExo;
	}

	public LocalDateTime getDebExo() {
		return debExo;
	}

	public void setDebExo(LocalDateTime debExo) {
		this.debExo = debExo;
	}

	public LocalDateTime getFinExo() {
		return finExo;
	}

	public void setFinExo(LocalDateTime finExo) {
		this.finExo = finExo;
	}

	public String getEtaExo() {
		return etaExo;
	}

	public void setEtaExo(String etaExo) {
		this.etaExo = etaExo;
	}

	@Override
	public String toString() {
		return "Exercice [codExo=" + codExo + ", libExo=" + libExo + ", debExo=" + debExo + ", finExo=" + finExo
				+ ", etaExo=" + etaExo + "]";
	}
	
	public String element() {
		return codExo + "; " + libExo + "; " + debExo + "; " + finExo
				+ "; " + etaExo ;
	}
	
	public String[] structure(){
		String[] ch={"codExo", "libExo", "debExo", "finExo", "etaExo"};
		return ch;
	}

}
