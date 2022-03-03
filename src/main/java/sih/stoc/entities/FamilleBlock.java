package sih.stoc.entities;

public class FamilleBlock {
	private Famille fam;
	private String login;
	
	public FamilleBlock(Famille fam, String login) {
		super();
		this.fam = fam;
		this.login = login;
	}

	public Famille getFam() {
		return fam;
	}

	public void setFam(Famille fam) {
		this.fam = fam;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	

}
