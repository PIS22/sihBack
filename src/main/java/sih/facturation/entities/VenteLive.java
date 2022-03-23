package sih.facturation.entities;

import java.util.List;

import sih.stoc.entities.MouvementDetail;

public class VenteLive {
	
	private Vente vte;
	private List<MouvementDetail> lignes;
	
	public VenteLive(Vente vte, List<MouvementDetail> lignes) {
		super();
		this.vte = vte;
		this.lignes = lignes;
	}

	public Vente getVte() {
		return vte;
	}

	public void setVte(Vente vte) {
		this.vte = vte;
	}

	public List<MouvementDetail> getLignes() {
		return lignes;
	}

	public void setLignes(List<MouvementDetail> lignes) {
		this.lignes = lignes;
	}
	
	

}
