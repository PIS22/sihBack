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
					for( Article a: ar.findAll()) {
						if(a.isStockable()) {
							Stocker stk = new Stocker();
							stk.setArticle(a);
							stk.setMag(mg);
							if (repo.familleParMagasin(mg.getCodMag()).contains(a.getFamilleArt().getCodFam())) {
								stk.setAutorise(true);
							} else {
								stk.setAutorise(false);
							}
							sr.save(stk);
						}
						
					}
			}
			return mg;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		/*
		Magasin nouveau = repo.save(elt);
		if (!nouveau.equals(null)) {
				for( Article a: ar.findAll()) {
					Stocker stk= new Stocker();
					stk.setArticle(a);
					stk.setMag(nouveau);
					if(repo.familleParMagasin(nouveau.getIdMag()).contains(a.getFamilleArt().getIdFam())) {
						stk.setAutorise(true);
					}
					else {
						stk.setAutorise(false);
					}
					sr.save(stk);
				}
			Agir act = new Agir();
			act.setNouvellesValeurs(nouveau.toString());
			act.setTable(orepo.findById("Magasin").get());
			act.setUser(us.findByLogin(u));
			act.setDatActe(LocalDateTime.now());
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
			else {
				return null;
			}*/
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
	
		/*Magasin ancien = repo.findById(elt.getIdMag()).get();
		Magasin nouveau = repo.save(elt);
		if (!nouveau.equals(null)) {
			for(Stocker s: sr.findByIdMag(nouveau.getIdMag())) {
				if(repo.familleParMagasin(s.getMag().getIdMag()).contains(s.getArticle().getFamilleArt().getIdFam())){
					s.setAutorise(true);
				}
				else {
					s.setAutorise(false);
				}
				sr.save(s);
			}
			Agir act = new Agir();
			act.setAnciennesValeurs(ancien.toString());
			act.setNouvellesValeurs(nouveau.toString());
			act.setTable(orepo.findById("Magasin").get());
			act.setUser(us.findByLogin(u));
			act.setDatActe(LocalDateTime.now());
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;*/
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
		/*repo.deleteById(mg.getIdMag());
		if (!repo.existsById(mg.getIdMag())) {
			Agir act = new Agir();
			act.setAnciennesValeurs(mg.toString());
			act.setTable(orepo.findById("Magasin").get());
			act.setUser(us.findByLogin(u));
			act.setAction("Supression");
			act.setDatActe(LocalDateTime.now());
			aux.save(act);
		}*/
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

}