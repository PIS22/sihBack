package sih.compta.entities;

import sih.securite.entities.Utilisateur;

public class CompteBlock {
	
	Compte compte;
	Utilisateur user;
	public Compte getCompte() {
		return compte;
	}
	
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	

}
