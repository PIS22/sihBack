package sih.general.entities;

import sih.securite.entities.Utilisateur;

public class ServeBlock {
	
	ServicesSpecialises serve;
	Utilisateur auteur;
	
	
	public ServicesSpecialises getServe() {
		return serve;
	}
	public void setServe(ServicesSpecialises serve) {
		this.serve = serve;
	}
	public Utilisateur getAuteur() {
		return auteur;
	}
	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}
	

}
