package sih.stoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sih.stoc.entities.Article;
import sih.stoc.entities.Famille;
import sih.stoc.entities.Fournisseur;
import sih.stoc.entities.Magasin;
import sih.stoc.entities.Unite;
import sih.stoc.services.ArticleService;
import sih.stoc.services.FamilleService;
import sih.stoc.services.FournisseurService;
import sih.stoc.services.MagasinService;
import sih.stoc.services.UniteService;

@RestController
@CrossOrigin
@RequestMapping(path = "basestock/")
//@EnableJpaAuditing(auditorAwareRef ="Moi")

public class StocBaseController {
	@Autowired
	private MagasinService mag;
	@Autowired
	private UniteService unit;

	private final FamilleService familleService;
	private final ArticleService ArticleService;
	private final FournisseurService fournisseurService;

	public StocBaseController(FamilleService familleService, sih.stoc.services.ArticleService articleService,
			// MagasinService magasinService,
			FournisseurService fournisseurService) {
		super();
		this.familleService = familleService;
		ArticleService = articleService;
		// this.magasinService = magasinService;
		this.fournisseurService = fournisseurService;
	}
	// -----------ControllerFamille

	@GetMapping(path = "famille/list")
	public List<Famille> listFamille() {
		return this.familleService.list();
	}

	@GetMapping(path = "famille/byId/{id}")
	public Famille findFamille(@PathVariable(name = "id") String id) {
		return this.familleService.select(id);
	}

	@PostMapping("famille/list")
	Famille addingFamille(@RequestBody Famille fam) {
		return this.familleService.insert(fam);
	}

	@PutMapping("famille/list")
	public Famille editingFamille(@RequestBody Famille fam) {
		return this.familleService.edit(fam);
	}

	@DeleteMapping("famille/list/del")
	public void deletingFamille(@RequestBody Famille fam) {
		System.out.println("Supppp");
		this.familleService.delete(fam);
	}

	@DeleteMapping("famille/byId/{id}")
	public void deletingFamilleById(@PathVariable(name  ="id") String id,  String log) {
		this.familleService.deleteById(id, log);
	}

	// ------------ControllerFournisseur

	@GetMapping(path = "fournisseur/list")
	public List<Fournisseur> listFournisseur() {
		return this.fournisseurService.list();
	}

	@GetMapping(path = "fournisseur/byId/{id}")
	public Fournisseur findFournisseur(@PathVariable(name = "id") String id) {
		return this.fournisseurService.select(id);
	}

	@PostMapping("fournisseur/list")
	Fournisseur addingFournisseur(@RequestBody Fournisseur fourn) {
		return this.fournisseurService.insert(fourn);
	}

	@PutMapping("fournisseur/list")
	public Fournisseur editingFournisseur(@RequestBody Fournisseur fourn) {
		return this.fournisseurService.edit(fourn);
	}

	@DeleteMapping("fournisseur/list")
	public void deletingFournisseur(@RequestBody Fournisseur frs) {
		this.fournisseurService.delete(frs);
	}

	// ---ControllerArticle

	@GetMapping(path = "article/achetable/{val}/list")
	public List<Article> listAchetable(@PathVariable boolean val) {
		return this.ArticleService.listAchetable(val);
	}

	@GetMapping(path = "article/consommable/list")
	public List<Article> listConsommable() {
		return this.ArticleService.list();
	}

	@GetMapping(path = "article/vendable/list")
	public List<Article> listVendable() {
		return this.ArticleService.list();
	}

	@GetMapping(path = "article/list")
	public List<Article> listarticle() {
		return this.ArticleService.list();
	}

	@GetMapping(path = "article/byId/{id}")
	public Article findarticle(@PathVariable(name = "id") String id) {
		return this.ArticleService.select(id);
	}

	@PostMapping("article/list")
	public Article addingarticle(@RequestBody Article art) {
		return this.ArticleService.insert(art);
	}

	@PutMapping("article/list")
	public Article editingarticle(@RequestBody Article art) {
		return this.ArticleService.edit(art);
	}

	@DeleteMapping("article/list")
	public void deletingarticle(@RequestBody Article fam) {
		this.ArticleService.delete(fam);
	}

	// ---Controller Magasin

	@GetMapping(path = "magasin/list")
	public List<Magasin> listmag() {
		return this.mag.list();
	}

	@GetMapping(path = "magasin/byId/{id}")
	public Magasin findmag(@PathVariable(name = "id") String id) {
		return this.mag.select(id);
	}

	@GetMapping(path = "magasin/byCod/{cod}")
	public Magasin findMagByCod(@PathVariable(name = "cod") String cod) {
		return this.mag.select(cod);
	}

	@PostMapping("magasin/list")
	public Magasin addingmag(@RequestBody Magasin mag) {
		return this.mag.insert(mag);
	}

	@PutMapping("magasin/list")
	public Magasin editingmag(@RequestBody Magasin art) {
		return this.mag.edit(art);
	}

	@DeleteMapping("magasin/list")
	public void deletingmag(@RequestBody Magasin art) {
		this.mag.delete(art);
	}

	@DeleteMapping("magasin/byId/{id}")
	public void deletingMag(@PathVariable(name = "id") String id) {
		this.mag.delete(id);
	}

	// ---Controller Unite

	@GetMapping(path = "unite/list")
	public List<Unite> listUnit() {
		return this.unit.list();
	}

	@GetMapping(path = "unite/byId/{id}")
	public Unite findUnite(@PathVariable(name = "id") String id) {
		return this.unit.select(id);
	}

	@GetMapping(path = "unite/byCod/{cod}")
	public Unite findUnitByCod(@PathVariable(name = "cod") String cod) {
		return this.unit.select(cod);
	}

	@PostMapping("unite/list")
	public Unite addingUnit(@RequestBody Unite art) {
		return this.unit.insert(art);
	}

	@PutMapping("unite/list")
	public Unite editingmag(@RequestBody Unite art) {
		return this.unit.edit(art);
	}

	@DeleteMapping("unite/byId/{id}")
	public void deletingUNit(@PathVariable String id) {
		this.unit.deleteById(id);
	}

}
