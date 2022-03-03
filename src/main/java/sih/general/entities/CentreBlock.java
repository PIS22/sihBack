package sih.general.entities;

import sih.securite.entities.Utilisateur;

public class CentreBlock {

	Centre centre;
	Utilisateur auteur;
	
	
	public Centre getCentre() {
		return centre;
	}
	public void setCentre(Centre centre) {
		this.centre = centre;
	}
	public Utilisateur getAuteur() {
		return auteur;
	}
	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}
}
