package sih.general.entities;

import sih.securite.entities.Utilisateur;

public class PharmaBlock {

	
	Pharmacie pharma;
	Utilisateur auteur;
	
	public PharmaBlock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pharmacie getPharma() {
		return pharma;
	}
	public void setPharma(Pharmacie pharma) {
		this.pharma = pharma;
	}
	
	public Utilisateur getAuteur() {
		return auteur;
	}
	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}
}
