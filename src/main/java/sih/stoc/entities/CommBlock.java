package sih.stoc.entities;

import java.util.List;

public class CommBlock {
	
	public Commande com;
	public List<CommandeDetail> lignes;
	
	public CommBlock(Commande com, List<CommandeDetail> lignes) {
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

	public List<CommandeDetail> getLignes() {
		return lignes;
	}

	public void setLignes(List<CommandeDetail> lignes) {
		this.lignes = lignes;
	}
	

}
