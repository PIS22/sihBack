package sih.general.entities;

import sih.securite.entities.Utilisateur;

public class TypeCentreBlock {

	
	TypeCentre type;
	
	public TypeCentre getType() {
		return type;
	}
	public void setType(TypeCentre type) {
		this.type = type;
	}
	Utilisateur auteur;
	public Utilisateur getAuteur() {
		return auteur;
	}
	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}
}
