package sih.stoc.entities;

public class UniteBlock {
	public Unite unite;
	public String login;
	
	public UniteBlock(Unite unite, String login) {
		super();
		this.unite = unite;
		this.login = login;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
