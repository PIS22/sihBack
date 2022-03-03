package sih.stoc.entities;


public class Disponibilite {
	private Long articleIdArticle;
	private String codArt;
	private String libArt;
	private String libCou;
	private double qte;
	
	public Disponibilite(Long articleIdArticle, String codArt, String libArt, String libCou, double qte) {
		super();
		this.articleIdArticle = articleIdArticle;
		this.codArt = codArt;
		this.libArt = libArt;
		this.libCou = libCou;
		this.qte = qte;
	}

	public Long getArticleIdArticle() {
		return articleIdArticle;
	}

	public void setArticleIdArticle(Long articleIdArticle) {
		this.articleIdArticle = articleIdArticle;
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

	public double getQte() {
		return qte;
	}

	public void setQte(double qte) {
		this.qte = qte;
	}

}
