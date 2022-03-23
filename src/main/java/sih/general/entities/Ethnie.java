package sih.general.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import sih.securite.config.Audit;
import sih.securite.entities.Utilisateur;

@SuppressWarnings("serial")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Ethnie extends Audit<Utilisateur> implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String libelle;
	
	public Ethnie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Ethnie(Long id, String libelle) {
		super();
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Ethnie [id=" + id + ", libelle=" + libelle + "]";
	}
	

}
