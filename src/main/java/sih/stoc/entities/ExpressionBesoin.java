package sih.stoc.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import sih.general.entities.Exercice;
import sih.securite.entities.Utilisateur;

@SuppressWarnings("serial")
@Entity
public class ExpressionBesoin implements Serializable{
	@Id
	private String numEB;
	@Column(nullable = false, updatable = true)
	private LocalDateTime datEB;
	private String obs;
	private String etat;
	@ManyToOne(targetEntity = Utilisateur.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "idUser", referencedColumnName = "idUser")
	private Utilisateur user;
	private int rang;
	
	@ManyToOne(targetEntity = Exercice.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "codeExo", referencedColumnName = "codExo")
	private Exercice exo;

	public ExpressionBesoin() {
		// TODO Auto-generated constructor stub
	}

	public ExpressionBesoin(String numEB, LocalDateTime datEB, String obs, String etat, Utilisateur user,
			Exercice exo) {
		super();
		this.numEB = numEB;
		this.datEB = datEB;
		this.obs = obs;
		this.etat = etat;
		this.user = user;
		this.exo = exo;
	}

	public String getNumEB() {
		return numEB;
	}

	public void setNumEB(String numEB) {
		this.numEB = numEB;
	}

	public int getRang() {
		return rang;
	}

	public void setRang(int rang) {
		this.rang = rang;
	}

	public LocalDateTime getDatEB() {
		return datEB;
	}

	public void setDatEB(LocalDateTime datEB) {
		this.datEB = datEB;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Exercice getExo() {
		return exo;
	}

	public void setExo(Exercice exo) {
		this.exo = exo;
	}

	@Override
	public String toString() {
		return "ExpressionBesoin [numEB=" + numEB + ", datEB=" + datEB + ", obs=" + obs + ", etat=" + etat + ", user="
				+ user + ", exo=" + exo + "]";
	}

	public String element() {
		return  numEB + "; " + datEB + "; " + obs + ";  " + etat + "; "+ user + "; " + exo ;
	}
	
}
