package sih.general.entities;

import sih.securite.entities.Utilisateur;

public class ExerciceBlock {
	public Exercice exo;
	public Utilisateur auteur;
	
	public ExerciceBlock(Exercice exo, Utilisateur auteur) {
		super();
		this.exo = exo;
		this.auteur = auteur;
	}
	
	public Exercice getExo() {
		return exo;
	}
	
	public void setExo(Exercice exo) {
		this.exo = exo;
	}
	
	public Utilisateur getAuteur() {
		return auteur;
	}
	
	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}

}
