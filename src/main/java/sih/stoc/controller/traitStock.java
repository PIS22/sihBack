package sih.stoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sih.stoc.entities.CommBlock;
import sih.stoc.entities.Commande;
import sih.stoc.entities.CommandeDet;
import sih.stoc.repositories.CommandeService;

@RestController
@RequestMapping("traitstock/")
public class traitStock {
	@Autowired
	private CommandeService cmd;

	@GetMapping("commande/{exo}/list")
	public List<Commande> listCommande(@PathVariable(name = "exo") int exo){
		return cmd.listCom(exo);
	}

	@GetMapping("commande/list")
	public List<Commande> commandeValide(){
		return cmd.commandeValides();
	}
	
	@GetMapping("commande/{num}/detail")
	public List<CommandeDet> detailCommande(@PathVariable(name = "num") String num){
		return cmd.detailCommande(num);
	}
	
	@PostMapping("commande/list")
	public Commande insertCom(@RequestBody CommBlock com) {
		return cmd.insert(com);
	}

}
