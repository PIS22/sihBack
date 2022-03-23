package sih.stoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sih.facturation.entities.Vente;
import sih.facturation.entities.VenteDetail;
import sih.facturation.entities.VentePeriode;
import sih.facturation.services.VenteService;
import sih.stoc.entities.ComMag;
import sih.stoc.entities.CommBlock;
import sih.stoc.entities.Commande;
import sih.stoc.entities.CommandeDetail;
import sih.stoc.entities.Mouvement;
import sih.stoc.services.CommandeService;
import sih.stoc.services.MouvementService;

@RestController
@RequestMapping("traitstock/")
public class traitStock {
	@Autowired
	private CommandeService cmd;
	@Autowired
	private MouvementService rec;
	@Autowired
	private VenteService venteService;

	@GetMapping("commande/exo/{exo}/list")
	public List<Commande> listCommande(@PathVariable(name = "exo") int exo) {
		return cmd.listCom(exo);
	}

	@GetMapping("commande/list")
	public List<Commande> commandeValide() {
		return cmd.commandeValides();
	}

	@GetMapping("commande/{num}/detail")
	public List<CommandeDetail> detailCommande(@PathVariable(name = "num") String num) {
		return cmd.detailCommande(num);
	}

	@PostMapping("commande/list")
	public Commande insertCom(@RequestBody CommBlock com) {
		return cmd.insert(com);
	}

	@PostMapping("commande/reception/list")
	public Commande insertCom(@RequestBody ComMag com) {
		return cmd.insertCoRe(com);
	}

	@GetMapping("reception/{exo}/list")
	public List<Mouvement> listRecept(@PathVariable(name = "exo") int exo) {
		return rec.list(exo);
	}

	/////vente
	@GetMapping(path = "vente/list")
	public List<Vente> listvente() {
		return this.venteService.list();
	}

	@PostMapping(path = "vente/list/periode")
	public List<Vente> listventeP(@RequestBody VentePeriode vte) {
		return this.venteService.vetePeriode(vte);
	}

	@GetMapping(path = "vente/byId/{id}")
	public Vente findvente(@PathVariable(name = "id") String id) {
		return this.venteService.select(id);
	}

	@GetMapping(path = "vente/{id}/detail")
	public List<VenteDetail> detailvente(@PathVariable(name = "id") String id) {
		return this.venteService.detailVente(id);
	}

	@PostMapping("vente/list")
	public Vente addingvente(@RequestBody Vente vte) {
		return this.venteService.insert(vte);
	}

	@PutMapping("Vente/list")
	public Vente editingvente(@RequestBody Vente vte) {
		return this.venteService.edit(vte);
	}

	@DeleteMapping("Vente/byId/{id}")
	public void deletingvente(@PathVariable(name = "id") String id) {
		this.venteService.delete(id);
	}
}
