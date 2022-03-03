package sih.general.entities;

import sih.securite.entities.Utilisateur;

public class CommuneBlock {
	
	Commune com; 
	
	
	public Commune getCom() {
		return com;
	}
	public void setCom(Commune com) {
		this.com = com;
	}
	
	Utilisateur auteur;
	public Utilisateur getAuteur() {
		return auteur;
	}
	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}

}
