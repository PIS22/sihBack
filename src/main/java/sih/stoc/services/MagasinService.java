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
public class MagasinService {
	@Autowired
	ArticleRepo ar;
	@Autowired
	StockerRepository sr;
	@Autowired
	private ObjetRepo orepo;
	private final MagasinRepo repo;

	public MagasinService(MagasinRepo repo, AgirRepo aux) {
		super();
		this.repo = repo;
	}

	public Magasin insert(Magasin elt) {
		
		try {
			Magasin mg = repo.save(elt);
			if (!mg.equals(null)) {
				try {
					List<Article> articles=ar.findAll();
					for( Article a:articles ) {
						if(a.isStockable()) {
							Stocker stk = new Stocker(mg.getCodMag()+"_"+a.getCodArt(), 0, 0, a, mg);
							if (repo.familleParMagasin(mg.getCodMag()).contains(a.getFamilleArt().getCodFam())) {
								stk.setAutorise(true);
							} else {
								stk.setAutorise(false);
							}
							sr.save(stk);
						}
						
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			return mg;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
			}

	// Modification
	public Magasin edit(Magasin elt) {
		try {
		Magasin mg = repo.save(elt);
		if (!mg.equals(null)) {
				for( Article a: ar.findAll()) {
					Stocker stk= new Stocker();
					stk.setArticle(a);
					stk.setMag(mg);
					if(repo.familleParMagasin(mg.getCodMag()).contains(a.getFamilleArt().getCodFam())) {
						stk.setAutorise(true);
					}
					else {
						stk.setAutorise(false);
					}
					sr.save(stk);
				}
		}
		return mg;
	} catch (Exception e) {
		System.out.println(e.getMessage());
		return null;
	}
	}

	public void delete(String id) {
			repo.deleteById(id);
	}

	public void delete(Magasin mg) {
		try {
			sr.deleteAll(sr.findByIdMag(mg.getCodMag()));
			repo.delete(mg);
		} catch (Exception e) {System.out.print(e.getMessage());
		}
		
	}

	public List<Magasin> list() {
		try {
			if (!orepo.existsById("Magasin")) {
				try {
					orepo.save(new Objet("Magasin", "idMag; codMag; libMag"));
				} catch (Exception e) {
					System.out.printf("Vérification dexistence: ", e.getMessage());
				}
			}
			return repo.findAll();
		} catch (Exception e) {
			return null;
		}
	}


	public Magasin select(String cod) {
		return repo.findByCodMag(cod);
	}


	public List<Stocker> etatMag(String cmag){
		return sr.findByIdMag(cmag);
	}
	
	public List<Stocker> dispoArticle(String cart){
		return sr.findByIdArt(cart);
	}
	public List<Stocker> dispoArtMag(String cmag, String cart){
		return sr.findByMagArt(cmag, cart);
	}
	
	public List<Stocker> listStocker(){
		return sr.findAll();
	}


}