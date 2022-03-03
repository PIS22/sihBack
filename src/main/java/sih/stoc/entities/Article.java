package sih.stoc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import sih.securite.config.Audit;


@SuppressWarnings("serial")
@Entity
@EnableJpaAuditing(modifyOnCreate = true, setDates = true)
public class Article extends Audit<String> implements Serializable{

@Id
@Column(insertable = true, updatable = true)
private String codArt;
private String libArt;
private String libCou;
private boolean achetable;
private boolean numSerie;
private boolean stockable;
private boolean perissable;
private boolean consommable;
private boolean venArt;
@ManyToOne(targetEntity = Famille.class,fetch = FetchType.EAGER)
@JoinColumn(name = "famille", nullable = false)
private Famille familleArt;
@ManyToOne(targetEntity = Unite.class,fetch = FetchType.EAGER)
@JoinColumn(name = "unite", nullable = false)
private Unite unite;
private double prix;

	public Article() {
		// TODO Auto-generated constructor stub
	}
	
	public Article(String codArt, String libArt, String libCou, boolean achetable, boolean numSerie,
			boolean stockable, boolean perissable, boolean consommable, boolean venArt, Famille familleArt,
			Unite unite) {
		super();
		this.codArt = codArt;
		this.libArt = libArt;
		this.libCou = libCou;
		this.achetable = achetable;
		this.numSerie = numSerie;
		this.stockable = stockable;
		this.perissable = perissable;
		this.consommable = consommable;
		this.venArt = venArt;
		this.familleArt = familleArt;
		this.unite = unite;
	}

	public String getCodArt() {
		return codArt;
	}

	public void setCodArt(String codArt) {
		this.codArt = codArt;
	}

	public String getLibArt() {
		return libArt;
	}

	public void setLibArt(String libArt) {
		this.libArt = libArt;
	}

	public String getLibCou() {
		return libCou;
	}

	public void setLibCou(String libCou) {
		this.libCou = libCou;
	}

	public boolean isAchetable() {
		return achetable;
	}

	public void setAchetable(boolean achetable) {
		this.achetable = achetable;
	}

	public boolean isNumSerie() {
		return numSerie;
	}

	public void setNumSerie(boolean numSerie) {
		this.numSerie = numSerie;
	}

	public boolean isStockable() {
		return stockable;
	}

	public void setStockable(boolean stockable) {
		this.stockable = stockable;
	}

	public boolean isPerissable() {
		return perissable;
	}

	public void setPerissable(boolean perissable) {
		this.perissable = perissable;
	}

	public boolean isConsommable() {
		return consommable;
	}

	public void setConsommable(boolean consommable) {
		this.consommable = consommable;
	}

	public boolean isVenArt() {
		return venArt;
	}

	public void setVenArt(boolean venArt) {
		this.venArt = venArt;
	}

	public Famille getFamilleArt() {
		return familleArt;
	}

	public void setFamilleArt(Famille familleArt) {
		this.familleArt = familleArt;
	}

	public Unite getUnite() {
		return unite;
	}

	public void setUnite(Unite unite) {
		this.unite = unite;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String element() {
		return "Article("  + codArt + "; " + libArt + "; " +familleArt.getCodFam()+ ")";
	}

	public String valeur() {
		return  codArt + "; " + libArt + "; " + libCou + "; " + venArt + "; "
				+ stockable + "; " + perissable + "; " + consommable + "; "+ "; " +
				achetable + "; " + familleArt+ "; " + unite+ "; " + prix ;
	}

	@Override
	public String toString() {
		return "Article [codArt=" + codArt + ", libArt=" + libArt + ", libCou=" + libCou
				+ ", venArt=" + venArt + ", stockable=" + stockable + ", perissable=" + perissable
				+ ", consommable=" + consommable + ", achetable=" + achetable + ", familleArt="
				+ familleArt + ", unite=" + unite + ", prix=" + prix + "]";
	}
	
}
