package sih.securite.entities;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


@SuppressWarnings("serial")
@Entity
public class Utilisateur implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;
	@Column(nullable = false, unique = true, updatable = true)
	private String login;
	private String shareCode;
	//private String nom;
	//private String prenom;
	private String pass;
	private boolean enLigne;
	@ManyToMany(fetch = FetchType.EAGER)
	//@JoinTable(name = "RoleUser")
	public Collection<AppRole> roles= new ArrayList<AppRole>();
	
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(String login, String pass) {
		super();
		this.login = login;
		//this.nom = nom;
		//this.prenom = prenom;
		this.pass = pass;
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

/*	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}*/

	@JsonIgnore
	public String getShareCode() {
		return shareCode;
	}

	@JsonSetter
	public void setShareCode(String shareCode) {
		this.shareCode = shareCode;
	}

	@JsonIgnore
	public String getPass() {
		return pass;
	}

	@JsonSetter
	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isEnLigne() {
		return enLigne;
	}

	public void setEnLigne(boolean enLigne) {
		this.enLigne = enLigne;
	}

	public Collection<AppRole> getRoles() {
		return roles;
	}

	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUser=" + idUser + ", login=" + login + ", shareCode=" + shareCode + ", pass=" + pass
				+ ", enLigne=" + enLigne+"]";
	}

	public String element() {
		return idUser + ";" + shareCode + ";" +  login ;
	}

	public List<String> structure(){
		List<String> ch= new ArrayList<>();
		for(Field f: this.getClass().getFields()) {
			ch.add(f.getName());
		}
		return ch;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
