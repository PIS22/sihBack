package sih.stoc.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import sih.securite.config.Audit;

@Entity
public class MouvementDetail  extends Audit<String> implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String idDet;
	private double qteEnt;
	private double qteSor;
	private double pu;
	private String obs;
	@ManyToOne(targetEntity = Mouvement.class)
	private Mouvement mvt;
	@ManyToOne(targetEntity = Article.class)
	private Article art;
	@ManyToOne(targetEntity = Magasin.class)
	private Magasin mag;
	@Column(nullable = true)
	private LocalDate exp;
	
	public MouvementDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MouvementDetail(double qteEnt, double qteSor, double pu, String obs, Mouvement mvt, Article art,
			LocalDate exp) {
		super();
		this.qteEnt = qteEnt;
		this.qteSor = qteSor;
		this.pu = pu;
		this.obs = obs;
		this.mvt = mvt;
		this.art = art;
		this.exp = exp;
	}

	public String getIdDet() {
		return idDet;
	}

	public void setIdDet(String idDet) {
		this.idDet = idDet;
	}

	public double getQteEnt() {
		return qteEnt;
	}

	public void setQteEnt(double qteEnt) {
		this.qteEnt = qteEnt;
	}

	public double getQteSor() {
		return qteSor;
	}

	public void setQteSor(double qteSor) {
		this.qteSor = qteSor;
	}

	public double getPu() {
		return pu;
	}

	public void setPu(double pu) {
		this.pu = pu;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Mouvement getMvt() {
		return mvt;
	}

	public void setMvt(Mouvement mvt) {
		this.mvt = mvt;
	}

	public Article getArt() {
		return art;
	}

	public void setArt(Article art) {
		this.art = art;
	}

	public LocalDate getExp() {
		return exp;
	}

	public void setExp(LocalDate exp) {
		this.exp = exp;
	}

	public Magasin getMag() {
		return mag;
	}

	public void setMag(Magasin mag) {
		this.mag = mag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
