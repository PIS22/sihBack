package sih.stoc.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.stoc.entities.CommBlock;
import sih.stoc.entities.Commande;
import sih.stoc.entities.CommandeDet;

@Service
public class CommandeService {
	@Autowired
	CommandeRepo com;
	@Autowired
	ComDetRepo cd;

	public List<Commande> listCom(int exo) {
		return com.list(exo);
	}

	public List<Commande> commandeValides() {
		return com.commandeEligibles();
	}

	public List<CommandeDet> detailCommande(String num) {
		return com.detailCommande(num);
	}

	public Commande insert(CommBlock cmd) {
		try {
			int rang= com.dernier(cmd.getCom().getExo().getCodExo());
			String num=null;
			if(rang==0) {
				num= "CA"+ cmd.getCom().getExo().getCodExo()+"-0001";
			}
			else {
				for(int i=0; i<(4-String.valueOf(rang+1).length()); i++) {
					num="0"+rang+1;
				}
				num= "CA"+ cmd.getCom().getExo().getCodExo()+ num;
			}
			cmd.getCom().setNumCom(num);
			cmd.getCom().setOrdre(rang+1);
			Commande c = com.save(cmd.getCom());
			cmd.getLignes().forEach(l -> {
				l.setIdComDet(c.getNumCom() + "_" + l.getArt().getCodArt());
			});
			try {
				cd.saveAll(cmd.getLignes());
				return c;
			} catch (Exception e) {
				System.out.print(e.getMessage());
				return null;
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			return null;
		}
	}

	public Commande edit(CommBlock cmd) {
		try {
			Commande c = com.save(cmd.getCom());
			try {
				com.suppDetailCom(cmd.getCom().getNumCom());
				cmd.getLignes().forEach(l -> {
					l.setIdComDet(c.getNumCom() + "_" + l.getArt().getCodArt());
				});

				try {
					cd.saveAll(cmd.getLignes());
					return c;
				} catch (Exception e) {
					System.out.print(e.getMessage());
					return null;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.print(e.getMessage());
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			return null;
		}
	}

}
