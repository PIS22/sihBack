package sih.stoc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class ExpressionDetail implements Serializable{
	@Id
	@GeneratedValue
	private Long idLigEB;
	@Column(nullable = false)
	private double qteDemandee;
	private double qteAccordee;
	private double qteServie;
	@ManyToOne(targetEntity = ExpressionBesoin.class)
	private ExpressionBesoin eb;
	@ManyToOne(targetEntity = Article.class)
	private Article article;

	public ExpressionDetail() {
		// TODO Auto-generated constructor stub
	}

	public ExpressionDetail(double qteDemandee, double qteAccordee, double qteServie, ExpressionBesoin eb,
			Article article) {
		super();
		this.qteDemandee = qteDemandee;
		this.qteAccordee = qteAccordee;
		this.qteServie = qteServie;
		this.eb = eb;
		this.article = article;
	}

	public Long getIdLigEB() {
		return idLigEB;
	}

	public void setIdLigEB(Long idLigEB) {
		this.idLigEB = idLigEB;
	}

	public double getQteDemandee() {
		return qteDemandee;
	}

	public void setQteDemandee(double qteDemandee) {
		this.qteDemandee = qteDemandee;
	}

	public double getQteAccordee() {
		return qteAccordee;
	}

	public void setQteAccordee(double qteAccordee) {
		this.qteAccordee = qteAccordee;
	}

	public double getQteServie() {
		return qteServie;
	}

	public void setQteServie(double qteServie) {
		this.qteServie = qteServie;
	}

	public ExpressionBesoin getEb() {
		return eb;
	}

	public void setEb(ExpressionBesoin eb) {
		this.eb = eb;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "LigneEB [idLigEB=" + idLigEB + ", qteDemandee=" + qteDemandee + ", qteAccordee=" + qteAccordee
				+ ", qteServie=" + qteServie + ", eb=" + eb + ", article=" + article + "]";
	}
	
	public String element() {
		return idLigEB + ", " + qteDemandee + ", " + qteAccordee
				+ ", " + qteServie + ", " + eb + ", " + article;
	}

}
