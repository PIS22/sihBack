package sih.compta.entities;

import sih.securite.entities.Utilisateur;

public class JournalBlock {
	Journal jrn;
	Utilisateur us;
	public Journal getJrn() {
		return jrn;
	}
	public void setJrn(Journal jrn) {
		this.jrn = jrn;
	}
	public Utilisateur getUs() {
		return us;
	}
	public void setUs(Utilisateur us) {
		this.us = us;
	}
	

}
