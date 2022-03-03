package sih.stoc.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import sih.securite.config.Audit;


@SuppressWarnings("serial")
@Entity
@Table
@EnableJpaAuditing


public class Magasin extends Audit<String> implements Serializable {

	@Id
	@Column(unique = true, nullable = false, length = 5, updatable = true)
	private String codMag;
	@Column(nullable = false)
	private String libMag;
	@ManyToMany(targetEntity = Famille.class)
	@JoinTable(name = "FamillesAutorisees")
	private List<Famille> familles;

	public Magasin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Magasin(String codMag, String libMag) {
		super();
		this.codMag = codMag;
		this.libMag = libMag;
	}

	public String getCodMag() {
		return codMag;
	}

	public void setCodMag(String codMag) {
		this.codMag = codMag;
	}

	public String getLibMag() {
		return libMag;
	}

	public void setLibMag(String libMag) {
		this.libMag = libMag;
	}

	public List<Famille> getFamilles() {
		return familles;
	}

	public void setFamilles(List<Famille> familles) {
		this.familles = familles;
	}

	@Override
	public String toString() {
		return "Magasin [codMag=" + codMag + ", libMag=" + libMag + ", familles=" + familles + "]";
	}
	
	

}
