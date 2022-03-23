package sih.facturation.entities;

import java.util.List;

public class VenteBloc {
	private Vente vte;
	private List<VenteDetail> lines;
	
	public VenteBloc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VenteBloc(Vente vte, List<VenteDetail> lines) {
		super();
		this.vte = vte;
		this.lines = lines;
	}


	public Vente getVte() {
		return vte;
	}

	public void setVte(Vente vte) {
		this.vte = vte;
	}

	public List<VenteDetail> getLines() {
		return lines;
	}

	public void setLines(List<VenteDetail> lines) {
		this.lines = lines;
	}
	

}
