package sih.general.entities;

import sih.securite.entities.Utilisateur;

public class DDSBlock {

	DDS dds; 
	Utilisateur auteur;
	public DDS getDds() {
		return dds;
	}
	public void setDds(DDS dds) {
		this.dds = dds;
	}
	public Utilisateur getAuteur() {
		return auteur;
	}
	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}
	
}
