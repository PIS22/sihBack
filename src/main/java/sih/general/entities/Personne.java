package sih.general.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import sih.securite.config.Audit;
import sih.securite.entities.Utilisateur;

@SuppressWarnings("serial")
@Entity
//@EntityListeners(AuditingEntityListener)
public class Personne extends Audit<Utilisateur> implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPers; 
	private String nom;
	private String pren;
	private LocalDateTime dNais;
	private String lNais;
	private String Sexe;
	private String profession;
	private String sigPar;
	private String tel;
	private String bp;
	private String rue;
	private String adresse;
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinTable(name = "relation")
	private Set<Personne> liens= new HashSet<>();
	public Personne() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personne(String nom, String pren, LocalDateTime dNais, String lNais, String sexe,
			String profession, String sigPar, String tel, String bp, String rue, String adresse) {
		super();
		this.nom = nom;
		this.pren = pren;
		this.dNais = dNais;
		this.lNais = lNais;
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

	public LocalDateTime getdNais() {
		return dNais;
	}

	public void setdNais(LocalDateTime dNais) {
		this.dNais = dNais;
	}

	public String getlNais() {
		return lNais;
	}

	public void sethNais(String lNais) {
		this.lNais = lNais;
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
