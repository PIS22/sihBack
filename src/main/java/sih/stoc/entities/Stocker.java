package sih.stoc.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Stocker implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue()
	private Long idStk;
	private double stkInit;
	private double priInit;
	private double qteStk;
	private double cump;
	@ManyToOne(targetEntity = Article.class)
	private Article article;
	@ManyToOne(targetEntity = Magasin.class)
	private Magasin mag;
	private boolean autorise;
	@Column(nullable = true)
	private LocalDate exp;
	
	public Stocker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stocker(Long idStk, double qteStk, double cump, Article article, Magasin mag) {
		super();
		this.idStk = idStk;
		this.qteStk = qteStk;
		this.cump = cump;
		this.article = article;
		this.mag = mag;
	}

	public Long getIdStk() {
		return idStk;
	}

	public void setIdStk(Long idStk) {
		this.idStk = idStk;
	}

	public double getQteStk() {
		return qteStk;
	}

	public void setQteStk(double qteStk) {
		this.qteStk = qteStk;
	}

	public double getCump() {
		return cump;
	}

	public void setCump(double cump) {
		this.cump = cump;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Magasin getMag() {
		return mag;
	}

	public void setMag(Magasin mag) {
		this.mag = mag;
	}

	public boolean isAutorise() {
		return autorise;
	}

	public void setAutorise(boolean autorise) {
		this.autorise = autorise;
	}

	public double getStkInit() {
		return stkInit;
	}

	public void setStkInit(double stkInit) {
		this.stkInit = stkInit;
	}

	public double getPriInit() {
		return priInit;
	}

	public void setPriInit(double priInit) {
		this.priInit = priInit;
	}

	public LocalDate getExp() {
		return exp;
	}

	public void setExp(LocalDate exp) {
		this.exp = exp;
	}

	public String valeur() {
		return idStk + ", stkInit=" + stkInit + "t=" + priInit + ", qteStk=" + qteStk
				+ ", cump=" + cump + ", article=" + article + ", mag=" + mag + ", autorise=" + autorise + ", exp=" + exp
				+ "]";
	}

}
