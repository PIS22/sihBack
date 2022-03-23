package sih.stoc.entities;

import java.util.List;

public class MouvementBlock {
	
	private Mouvement recep;
	private List<MouvementDetail> lignes;
	
	public Mouvement getRecep() {
		return recep;
	}
	
	public MouvementBlock(Mouvement recep, List<MouvementDetail> lignes) {
		super();
		this.recep = recep;
		this.lignes = lignes;
	}

	public void setRecep(Mouvement recep) {
		this.recep = recep;
	}
	
	public List<MouvementDetail> getLignes() {
		return lignes;
	}
	
	public void setLignes(List<MouvementDetail> lignes) {
		this.lignes = lignes;
	}
	
	

}
