package sih.facturation.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import sih.securite.config.Audit;
import sih.stoc.entities.Article;

//import sih.stoc.entities.Vente;

@SuppressWarnings("serial")
@Entity
public class VenteDetail extends Audit<String> implements Serializable {

	public VenteDetail() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idVentDetail;
	private double qteVendu;
	private double prixVente;
	private double tva;
	private double qteLiv;
	private double remise;
	
	@ManyToOne(targetEntity = Vente.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "idVente", referencedColumnName = "idVente", nullable = false, updatable = true, insertable = true)
	private Vente vte;
	
	@ManyToOne(targetEntity = Article.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "codArt", referencedColumnName = "codArt", nullable = false, updatable = true, insertable = true)
	private Article art;
	
	public VenteDetail(int qteVendu, double prixVente,Vente Vte, Article Art) {
		super();
		this.qteVendu = qteVendu;
		this.prixVente = prixVente;
		this.vte= Vte;
		this.art = Art;
	}


	public Long getIdVentDetail() {
		return idVentDetail;
	}


	public void setIdVentDetail(Long idVentDetail) {
		this.idVentDetail = idVentDetail;
	}
//

	public double getQteVendu() {
		return qteVendu;
	}


	public void setQteVendu(double qteVendu) {
		this.qteVendu = qteVendu;
	}


	public double getPrixVente() {
		return prixVente;
	}


	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}


	public double getQteLiv() {
		return qteLiv;
	}


	public void setQteLiv(double qteLiv) {
		this.qteLiv = qteLiv;
	}


	public Vente getVte() {
		return vte;
	}


	public void setVte(Vente vte) {
		this.vte = vte;
	}


	public Article getArt() {
		return art;
	}


	public void setArt(Article art) {
		this.art = art;
	}


	public double getRemise() {
		return remise;
	}


	public void setRemise(double remise) {
		this.remise = remise;
	}


	public double getTva() {
		return tva;
	}


	public void setTva(double tva) {
		this.tva = tva;
	}

}
