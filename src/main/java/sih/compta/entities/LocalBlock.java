package sih.compta.entities;

import sih.securite.entities.Utilisateur;

public class LocalBlock {
	Localisation local;
	Utilisateur use;
	public Localisation getLocal() {
		return local;
	}
	public void setLocal(Localisation local) {
		this.local = local;
	}
	public Utilisateur getUse() {
		return use;
	}
	public void setUse(Utilisateur use) {
		this.use = use;
	}
	

}
