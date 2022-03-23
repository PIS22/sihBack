package sih.stoc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.stoc.entities.ComMag;
import sih.stoc.entities.CommBlock;
import sih.stoc.entities.Commande;
import sih.stoc.entities.CommandeDetail;
import sih.stoc.entities.Mouvement;
import sih.stoc.entities.MouvementDetail;
import sih.stoc.repositories.ComDetRepo;
import sih.stoc.repositories.CommandeRepo;

@Service
public class CommandeService {
	@Autowired
	CommandeRepo com;
	@Autowired
	ComDetRepo cd;;
	@Autowired
	private MouvementService ms;
	//private List<MouvementDetail> line;

	public List<Commande> listCom(int exo) {
		return com.list(exo);
	}

	public List<Commande> commandeValides() {
		return com.commandeEligibles();
	}

	public List<CommandeDetail> detailCommande(String num) {
		return cd.detailByCom(num);
	}

	public Commande insert(CommBlock cmd) {
		try {
			Commande c = com.dernier(cmd.getCom().getExo().getCodExo());
			int rang;
			String num = "CA" + cmd.getCom().getExo().getCodExo() + "-";
			if (c == null)
				rang = 1;
			else {
				rang = c.getOrdre() + 1;
			}
			for (int i = 0; i <= (5 - String.valueOf(rang).length()); i++) {
				num += 0;
			}
			num += rang;
			cmd.getCom().setNumCom(num);
			cmd.getCom().setOrdre(rang);
			Commande cm = com.save(cmd.getCom());
			cmd.getLignes().forEach(l -> {
				l.setCom(cm);
				l.setIdComDet(cm.getNumCom() + "_" + l.getArt().getCodArt());
			});
			cd.saveAll(cmd.getLignes());
				return cm;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			return null;
		}
	}

	public Commande insertCoRe(ComMag com) {
		/*com.getBlk().getCom().setActive(false);
		com.getBlk().getLignes().forEach(l->{
			l.setQteLiv(l.getQteCom());
		});*/
		Commande c=insert(com.getBlk());
		Mouvement mvt=new Mouvement();
		mvt.setExo(c.getExo());
		mvt.setCom(c);
		mvt.setDatMvt(c.getDatCom());
		mvt.setTypMvt("Réception");
		mvt.setSensMvt("Entrée");
		List<MouvementDetail> lmvt= new ArrayList<MouvementDetail>();
		for(CommandeDetail l:com.getBlk().getLignes()) {
			MouvementDetail md=new MouvementDetail(l.getQteCom(), 0, l.getPuCom(), "", mvt, l.getArt(), null);
			md.setMvt(mvt);
			md.setMag(com.getM());
			md.setIdDet(mvt.getNumMvt()+"_"+md.getArt().getCodArt());
			lmvt.add(md);			
		}
		ms.insert(mvt, lmvt);
		return c;
		
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
	
	public List<CommandeDetail> livraisomCom(String cm){
		return com.livraison(cm);
	}
}
