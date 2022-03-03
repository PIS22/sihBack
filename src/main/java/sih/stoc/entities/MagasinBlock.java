package sih.stoc.entities;

public class MagasinBlock {
	private Magasin mag;
	private String login;
	
	public MagasinBlock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MagasinBlock(Magasin mag, String login) {
		super();
		this.mag = mag;
		this.login = login;
	}

	public Magasin getMag() {
		return mag;
	}

	public void setMag(Magasin mag) {
		this.mag = mag;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
}
