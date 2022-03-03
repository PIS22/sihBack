package sih.compta.entities;

import sih.securite.entities.Utilisateur;

public class EtatImmoBlock {
	EtatImmo eta;
	Utilisateur use;
	public EtatImmo getEta() {
		return eta;
	}
	public void setEta(EtatImmo eta) {
		this.eta = eta;
	}
	public Utilisateur getUse() {
		return use;
	}
	public void setUse(Utilisateur use) {
		this.use = use;
	}

}
