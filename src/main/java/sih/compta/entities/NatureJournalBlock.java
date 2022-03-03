package sih.compta.entities;

import sih.securite.entities.Utilisateur;

public class NatureJournalBlock {
	NatureJournal natJrn;
	Utilisateur use;
	public NatureJournal getNatJrn() {
		return natJrn;
	}
	public void setNatJrn(NatureJournal natJrn) {
		this.natJrn = natJrn;
	}
	public Utilisateur getUse() {
		return use;
	}
	public void setUse(Utilisateur use) {
		this.use = use;
	}

}
