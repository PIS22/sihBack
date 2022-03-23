package sih.compta.entities;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import sih.securite.config.Audit;
import sih.stoc.entities.Article;

@Entity
public class CompteArticle extends Audit<String> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7942205161479528927L;
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idComArt;
	private Date debComArt;
	private Date finComArt;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Article.class)
	//@JoinColumn(name = "article", nullable = false, referencedColumnName = "codeArticle")
	private Article article;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Compte.class)
	@JoinColumn(name = "compte", nullable = false, referencedColumnName = "idCpte")
	private Compte compte;
	
	public CompteArticle() {
		// TODO Auto-generated constructor stub
	}

	public CompteArticle(Long idComArt, Date debComArt, Date finComArt, Article article, Compte compte) {
		super();
		this.idComArt = idComArt;
		this.debComArt = debComArt;
		this.finComArt = finComArt;
		this.article = article;
		this.compte = compte;
	}

	public Long getIdComArt() {
		return idComArt;
	}

	public void setIdComArt(Long idComArt) {
		this.idComArt = idComArt;
	}

	public Date getDebComArt() {
		return debComArt;
	}

	public void setDebComArt(Date debComArt) {
		this.debComArt = debComArt;
	}

	public Date getFinComArt() {
		return finComArt;
	}

	public void setFinComArt(Date finComArt) {
		this.finComArt = finComArt;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public String toString() {
		return "Associer [idComArt=" + idComArt + ", debComArt=" + debComArt + ", finComArt=" + finComArt + ", article="
				+ article + ", compte=" + compte + "]";
	}

	public List<String> structure(){
		List<String> ch= new ArrayList<>();
		for(Field f: this.getClass().getFields()) {
			ch.add(f.getName());
		}
		return ch;
	}
	

	public String element() {
		return idComArt + "; " + debComArt + "; " + finComArt + "; "+ article + "; " + compte;
	}
	
	

}
