package sih.compta.entities;

import sih.securite.entities.Utilisateur;

public class ImmoBlock {
	Immo immo;
	Utilisateur User;
	public Immo getImmo() {
		return immo;
	}
	public void setImmo(Immo immo) {
		this.immo = immo;
	}
	public Utilisateur getUser() {
		return User;
	}
	public void setUser(Utilisateur user) {
		User = user;
	}

}
