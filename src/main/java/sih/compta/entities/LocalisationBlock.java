package sih.compta.entities;

import sih.securite.entities.Utilisateur;

public class LocalisationBlock {
	Localisation loc;
	Utilisateur use;
	public Localisation getLoc() {
		return loc;
	}
	public void setLoc(Localisation loc) {
		this.loc = loc;
	}
	public Utilisateur getUse() {
		return use;
	}
	public void setUse(Utilisateur use) {
		this.use = use;
	}

}
