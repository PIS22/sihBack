package sih.stoc.entities;

import java.util.List;

public class CommBlock {
	
	public Commande com;
	public List<CommandeDet> lignes;
	
	public CommBlock(Commande com, List<CommandeDet> lignes) {
		super();
		this.com = com;
		this.lignes = lignes;
	}

	public Commande getCom() {
		return com;
	}

	public void setCom(Commande com) {
		this.com = com;
	}

	public List<CommandeDet> getLignes() {
		return lignes;
	}

	public void setLignes(List<CommandeDet> lignes) {
		this.lignes = lignes;
	}
	

}
