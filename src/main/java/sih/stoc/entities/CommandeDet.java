package sih.stoc.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import sih.securite.config.Audit;

@SuppressWarnings("serial")
@Entity
public class CommandeDet extends Audit<String> implements Serializable {
	@Id
	private String idComDet;
	private double puCom;
	private double qteCom;
	private double tva;
	private double remise;
	private double qteLiv;
	@ManyToOne(targetEntity = Commande.class)
	@JoinColumn(nullable = false)
	private Commande com;
	@ManyToOne(targetEntity = Article.class)
	@JoinColumn(nullable = false)
	private Article art;
	
	public CommandeDet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommandeDet(double puCom, double qteCom, double tva, double remise, double qteLiv, Commande com,
			Article art) {
		super();
		this.puCom = puCom;
		this.qteCom = qteCom;
		this.tva = tva;
		this.remise = remise;
		this.qteLiv = qteLiv;
		this.com = com;
		this.art = art;
	}

	public String getIdComDet() {
		return idComDet;
	}

	public void setIdComDet(String idComDet) {
		this.idComDet = idComDet;
	}

	public double getPuCom() {
		return puCom;
	}

	public void setPuCom(double puCom) {
		this.puCom = puCom;
	}

	public double getQteCom() {
		return qteCom;
	}

	public void setQteCom(double qteCom) {
		this.qteCom = qteCom;
	}

	public double getTva() {
		return tva;
	}

	public void setTva(double tva) {
		this.tva = tva;
	}

	public double getRemise() {
		return remise;
	}

	public void setRemise(double remise) {
		this.remise = remise;
	}

	public double getQteLiv() {
		return qteLiv;
	}

	public void setQteLiv(double qteLiv) {
		this.qteLiv = qteLiv;
	}

	public Commande getCom() {
		return com;
	}

	public void setCom(Commande com) {
		this.com = com;
	}

	public Article getArt() {
		return art;
	}

	public void setArt(Article art) {
		this.art = art;
	}
}
