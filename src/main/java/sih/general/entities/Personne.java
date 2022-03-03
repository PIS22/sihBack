package sih.general.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
//@EntityListeners(AuditingEntityListener)
public class Personne implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPers; 
	private String nom;
	private String pren;
	private LocalDate dNais;
	private LocalTime hNais;
	private String Sexe;
	private String profession;
	private String sigPar;
	private String tel;
	private String bp;
	private String rue;
	private String adresse;
	
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personne(Long idPers, String nom, String pren, LocalDate dNais, LocalTime hNais, String sexe,
			String profession, String sigPar, String tel, String bp, String rue, String adresse) {
		super();
		this.idPers = idPers;
		this.nom = nom;
		this.pren = pren;
		this.dNais = dNais;
		this.hNais = hNais;
		Sexe = sexe;
		this.profession = profession;
		this.sigPar = sigPar;
		this.tel = tel;
		this.bp = bp;
		this.rue = rue;
		this.adresse = adresse;
	}

	public Long getIdPers() {
		return idPers;
	}

	public void setIdPers(Long idPers) {
		this.idPers = idPers;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPren() {
		return pren;
	}

	public void setPren(String pren) {
		this.pren = pren;
	}

	public LocalDate getdNais() {
		return dNais;
	}

	public void setdNais(LocalDate dNais) {
		this.dNais = dNais;
	}

	public LocalTime gethNais() {
		return hNais;
	}

	public void sethNais(LocalTime hNais) {
		this.hNais = hNais;
	}

	public String getSexe() {
		return Sexe;
	}

	public void setSexe(String sexe) {
		Sexe = sexe;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getSigPar() {
		return sigPar;
	}

	public void setSigPar(String sigPar) {
		this.sigPar = sigPar;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	
}
