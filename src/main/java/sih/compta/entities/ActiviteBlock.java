package sih.compta.entities;

import sih.securite.entities.Utilisateur;

public class ActiviteBlock {
	Activite activite;
	Utilisateur user;
	public Activite getActivite() {
		return activite;
	}
	public void setActivite(Activite activite) {
		this.activite = activite;
	}
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	

}
