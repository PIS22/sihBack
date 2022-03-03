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
					Stocker s = new Stocker((long) 0, 0, 0, art, m);
					if (mr.familleParMagasin(m.getCodMag()).contains(art.getFamilleArt().getCodFam())) {
						s.setAutorise(true);
					} else {
						s.setAutorise(false);
					}
					sr.save(s);
				}
			}
			
			return art;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		/*Article nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			for(Magasin m: mr.findAll()) {
				Stocker s= new Stocker((long) 0, 0, 0, nouveau, m);
				if(mr.familleParMagasin(m.getIdMag()).contains(nouveau.getFamilleArt().getIdFam())) {
					s.setAutorise(true);
				}
				else {
					s.setAutorise(false);
				}
				sr.save(s);
			}
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setTable(orepo.findById("Article").get());
			act.setUser(ure.findByLogin(u));
			act.setAction("Ajout");
			act.setDatActe(LocalDateTime.now());
			aux.save(act);
			return nouveau;
		}
		return null;*/
	}
		// Modification
	public Article edit(Article elt) {
		
		try {
			Article art = repo.save(elt);
			if(!art.equals(null)) {
				for(Stocker s: sr.findByIdArt(art.getCodArt())) {
					if(mr.familleParMagasin(s.getMag().getCodMag()).contains(art.getFamilleArt().getCodFam())) {
						s.setAutorise(true);
					}
					else {
						s.setAutorise(false);
					}
					sr.save(s);
				}
			}
			return art;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		/*Article ancien=repo.findById(elt.getIdArt()).get();
		Article nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			for(Stocker s: sr.findByIdArt(nouveau.getIdArt())) {
				if(mr.familleParMagasin(s.getMag().getIdMag()).contains(nouveau.getFamilleArt().getIdFam())) {
					s.setAutorise(true);
				}
				else {
					s.setAutorise(false);
				}
				sr.save(s);
			}
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setTable(orepo.findById("Article").get());
			act.setUser(ure.findByLogin(us));
			act.setAction("Modification");
			act.setDatActe(LocalDateTime.now());
			aux.save(act);
			return nouveau;
		}
		return null;*/
	}
	
	public void delete(Article elt) {
		/*Article ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setTable(orepo.findById("Article").get());
				act.setUser(us);
				act.setAction("Supression");
				act.setDatActe(LocalDateTime.now());
				aux.save(act);
			}
		}*/
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

	public List<Article> listAchetable(boolean val){
		return repo.achetable(val);
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
