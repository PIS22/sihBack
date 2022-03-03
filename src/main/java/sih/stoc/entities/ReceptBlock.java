package sih.stoc.entities;

import java.util.List;

public class ReceptBlock {
	
	private Reception recep;
	private List<ReceptionDet> lignes;
	
	public Reception getRecep() {
		return recep;
	}
	
	public void setRecep(Reception recep) {
		this.recep = recep;
	}
	
	public List<ReceptionDet> getLignes() {
		return lignes;
	}
	
	public void setLignes(List<ReceptionDet> lignes) {
		this.lignes = lignes;
	}
	
	

}
