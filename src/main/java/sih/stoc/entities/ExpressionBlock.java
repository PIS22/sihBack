package sih.stoc.entities;

import java.util.List;

import sih.securite.entities.Utilisateur;

public class ExpressionBlock {
	private ExpressionBesoin eb;
	private List<ExpressionDetail> lines;
	public Utilisateur us;

	public ExpressionBlock() {
		// TODO Auto-generated constructor stub
	}

	public ExpressionBesoin getEb() {
		return eb;
	}

	public void setEb(ExpressionBesoin eb) {
		this.eb = eb;
	}

	public List<ExpressionDetail> getLines() {
		return lines;
	}

	public void setLines(List<ExpressionDetail> lines) {
		this.lines = lines;
	}
	
	public Utilisateur getUs() {
		return us;
	}

	public void setUs(Utilisateur us) {
		this.us = us;
	}

	public String element() {
		String sortie="[("+lines.get(0).element()+")";
		int i=0;
		while(i < lines.size()-1) {
			i++;
			sortie+=";("+lines.get(i).toString()+")";
		}
		sortie+="]";
		return eb.element()+sortie;
	}

}
