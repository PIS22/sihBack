package sih.compta.entities;

import sih.securite.entities.Utilisateur;

public class ModeBlock {
	ModePaiement mod;
	Utilisateur use;
	public ModePaiement getMod() {
		return mod;
	}
	public void setMod(ModePaiement mod) {
		this.mod = mod;
	}
	public Utilisateur getUse() {
		return use;
	}
	public void setUse(Utilisateur use) {
		this.use = use;
	}
	

}
