package sih.stoc.entities;

public class ArticleBlock {
	
	public Article article;
	public String login;
	
	public ArticleBlock(Article article, String login) {
		super();
		this.article = article;
		this.login = login;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
