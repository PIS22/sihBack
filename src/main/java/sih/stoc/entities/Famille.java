package sih.stoc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import sih.securite.config.Audit;

@SuppressWarnings("serial")
@Entity
@Table
@EnableJpaAuditing

public class Famille extends Audit<String> implements Serializable {

	@Id
	@Column(unique = true, nullable = false,updatable = true, length = 2)
	private String codFam;
	@Column(nullable = false)
	private String libFam;

	/*
	 * @CreatedDate private LocalDateTime creeLe;
	 * 
	 * @CreatedBy Utilisateur creePar;
	 * 
	 * @LastModifiedBy private LocalDateTime modifieLe;
	 * 
	 * @LastModifiedBy Utilisateur modifiePar;
	 * 
	 */

	public Famille() {
		// TODO Auto-generated constructor stub
	}

	public Famille(String codFam, String libFam) {
		this.codFam = codFam;
		this.libFam = libFam;
	}

	public String getCodFam() {
		return codFam;
	}

	public void setCodFam(String codFam) {
		this.codFam = codFam;
	}

	public String getLibFam() {
		return libFam;
	}

	public void setLibFam(String libFam) {
		this.libFam = libFam;
	}

	public String element() {
		return "Famille(" + codFam + "; " + libFam + ")";
	}

	@Override
	public String toString() {
		return "Famille [codFam=" + codFam + ", libFam=" + libFam + "]";
	}
}
