package sih.compta.entities;

import sih.securite.entities.Utilisateur;

public class CompteArticleBlock {
	CompteArticle comArt;
	Utilisateur user;
	public CompteArticle getComArt() {
		return comArt;
	}
	public void setComArt(CompteArticle cemArt) {
		this.comArt = cemArt;
	}
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
}
