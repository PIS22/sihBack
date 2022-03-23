package sih.securite.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


import sih.general.entities.Personne;


@SuppressWarnings("serial")
@Entity
public class Utilisateur implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	@Column(nullable = false, unique = true, updatable = true)
	private String login;
	private String shareCode;
	private String pass;
	@OneToOne(cascade = {CascadeType.DETACH})
	@JoinColumn(nullable = false)
	private Personne pers;
	private boolean enLigne;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "RoleUtilisateur")
	public List<AppRole> roles;
	
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Utilisateur(String login, String pass, Personne pers) {
		super();
		this.login = login;
		this.pass = pass;
		this.pers = pers;
	}


	public Long getIdUser() {
		return idUser;
	}


	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getShareCode() {
		return shareCode;
	}


	public void setShareCode(String shareCode) {
		this.shareCode = shareCode;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public Personne getPers() {
		return pers;
	}


	public void setPers(Personne pers) {
		this.pers = pers;
	}


	public boolean isEnLigne() {
		return enLigne;
	}


	public void setEnLigne(boolean enLigne) {
		this.enLigne = enLigne;
	}


	public List<AppRole> getRoles() {
		return roles;
	}


	public void setRoles(List<AppRole> roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "Utilisateur [idUser=" + idUser + ", login=" + login + ", shareCode=" + shareCode + ", pass=" + pass
				+ ", pers=" + pers + ", enLigne=" + enLigne + ", roles=" + roles + "]";
	}


}
