package sih.facturation.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import sih.securite.config.Audit;
import sih.securite.entities.Utilisateur;

@Entity
public class Caissier extends Audit<String> implements Serializable{
	
	private static final long serialVersionUID = -695316232621624252L;
	@Id
	private Long idCais; 
	private LocalDateTime deb;
	private LocalDate fin;
	@ManyToOne(targetEntity = Utilisateur.class, cascade = {CascadeType.DETACH})
	@JoinColumn(name = "caissier")
	private Utilisateur caissier;
	@ManyToOne(targetEntity = Caisse.class, cascade = {CascadeType.DETACH})
	@JoinColumn(name = "caisse")
	private Caisse caisse;
	
	public Caissier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Caissier(LocalDateTime deb, LocalDate fin, Utilisateur caissier, Caisse caisse) {
		super();
		this.deb = deb;
		this.fin = fin;
		this.caissier = caissier;
		this.caisse = caisse;
	}

	public Long getIdCais() {
		return idCais;
	}

	public void setIdCais(Long idCais) {
		this.idCais = idCais;
	}

	public LocalDateTime getDeb() {
		return deb;
	}

	public void setDeb(LocalDateTime deb) {
		this.deb = deb;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	public Utilisateur getCaissier() {
		return caissier;
	}

	public void setCaissier(Utilisateur caissier) {
		this.caissier = caissier;
	}

	public Caisse getCaisse() {
		return caisse;
	}

	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}
	
	
	
	

}
