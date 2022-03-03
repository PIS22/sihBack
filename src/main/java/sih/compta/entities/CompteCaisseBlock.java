package sih.compta.entities;

import sih.securite.entities.Utilisateur;

public class CompteCaisseBlock {
	
	CompteCaisse coca;
	Utilisateur use;
	public CompteCaisse getCoca() {
		return coca;
	}
	public void setCoca(CompteCaisse coca) {
		this.coca = coca;
	}
	public Utilisateur getUse() {
		return use;
	}
	public void setUse(Utilisateur use) {
		this.use = use;
	}

}
