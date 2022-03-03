package sih.general.entities;

import sih.securite.entities.Utilisateur;

public class ZoneSanitaireBlock {

	ZoneSanitaire zone; 
	Utilisateur auteur;
	
	
	public ZoneSanitaire getZone() {
		return zone;
	}
	public void setZone(ZoneSanitaire zone) {
		this.zone = zone;
	}
	public Utilisateur getAuteur() {
		return auteur;
	}
	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}	
}
