package sih.stoc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.securite.entities.Objet;
import sih.securite.repositories.AgirRepo;
import sih.securite.repositories.ObjetRepo;
import sih.stoc.entities.Article;
import sih.stoc.entities.Magasin;
import sih.stoc.entities.Stocker;
import sih.stoc.repositories.ArticleRepo;
import sih.stoc.repositories.MagasinRepo;
import sih.stoc.repositories.StockerRepository;

@Service
public class ArticleService {

	@Autowired
	private MagasinRepo mr;
	@Autowired
	private StockerRepository sr;
	@Autowired
	private ObjetRepo orepo;
	private final ArticleRepo repo;
	
	public ArticleService(ArticleRepo repo, AgirRepo aux) {
		super();
		this.repo = repo;
	}
	
	public Article insert(Article elt) {
		
		try {
			Article art= repo.save(elt);
			if(art.isStockable()) {
				for (Magasin m : mr.findAll()) {
					Stocker stk = new Stocker(m.getCodMag()+"_"+art.getCodArt(), 0, 0, art, m);
					if (m.getFamilles().contains(art.getFamilleArt())) {
						stk.setAutorise(true);
					} else {
						stk.setAutorise(false);
					}
					sr.save(stk);
				}
			}
			
			return art;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
		// Modification
	public Article edit(Article elt) {
		Article art= repo.save(elt);
		
		try {
			if(!repo.save(art).equals(null)) {
				if(art.isStockable()) {
					for(Magasin m: mr.findAll()){
						List<Stocker> stk=sr.findByMagArt(m.getCodMag(), art.getCodArt());
						if(stk.size()==0) {
							
								Stocker st=new Stocker(m.getCodMag()+"_"+art.getCodArt(), 0, 0, art, m);
								if(st.getMag().getFamilles().contains(st.getArticle().getFamilleArt())) {
									st.setAutorise(true);
								}
								else {
									st.setAutorise(false);
								}
								sr.save(st);
						}
						else {
							if(m.getFamilles().contains(art.getFamilleArt())) {
								stk.forEach(s->{
									s.setAutorise(true);
								});
							}
							else {
								stk.forEach(s->{
									s.setAutorise(false);
								});
							}
							sr.saveAll(stk);
						}
					}
				}
			}
			return art;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	
	}
	
	public void delete(Article elt) {
		
		try {
			 repo.delete(elt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Article> list(){
		try {
			if(!orepo.existsById("Article")) {
				orepo.save(new Objet("Article", "idArt; codArt; libArt; libCou; venteArt; stockable"
						+ "; perissable; consommable; prix; achetable; familleArt"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
		try {
			return repo.findAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

	public List<Article> listAchetable(){
		return repo.achetables();
	}

	public List<Article> listAchetableMag(String Mag){
		return repo.achetablesParMag(Mag);
	}

	public List<Article> listVendable(boolean val){
		return repo.vendable(val);
	}

	public List<Article> listConsommable(boolean val){
		return repo.consommable(val);
	}
	
	public Article select(String id) {
		return repo.findById(id).get();
	}
	
	
}
