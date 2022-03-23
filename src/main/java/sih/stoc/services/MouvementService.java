package sih.stoc.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.stoc.entities.Mouvement;
import sih.stoc.entities.MouvementDetail;
import sih.stoc.entities.Stocker;
import sih.stoc.repositories.CommandeRepo;
import sih.stoc.repositories.MouvementDetailRepo;
import sih.stoc.repositories.MouvementRepo;
import sih.stoc.repositories.StockerRepository;

@Service
public class MouvementService {
	@Autowired
	private MouvementRepo rec;
	@Autowired
	private MouvementDetailRepo dmvt;
	@Autowired
	private StockerRepository st;
	@Autowired
	CommandeRepo cr;

	public List<Mouvement> list(int exo) {
		return rec.list(exo);
	}

	public List<MouvementDetail> save(List<MouvementDetail> lines) {
		List<MouvementDetail> l= new ArrayList<>();
		try {
			l=dmvt.saveAll(lines);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return l;
	}
	
	public Mouvement insert(Mouvement m, List<MouvementDetail> det) {
		boolean livree = true;
		Mouvement mvt = new Mouvement();
		try {
			Mouvement dern = rec.dernier(m.getExo().getCodExo());
			int rang;
			if (dern == null) {
				rang = 1;
			} else {
				rang = dern.getOrdre() + 1;
			}
			String num = "MVT" + m.getExo().getCodExo();
			while (num.length() + String.valueOf(rang).length() < 15) {
				num += "0";
			}
			num += rang;
			m.setNumMvt(num);
			m.setOrdre(rang);
			try {
				mvt = rec.save(m);
				for (MouvementDetail d : det) {
					String idDet = mvt.getNumMvt() + "_" + d.getArt().getCodArt();
					if (d.getArt().isPerissable()) {
						idDet += "_" + String.valueOf(d.getExp().getDayOfMonth())
								+ String.valueOf(d.getExp().getMonthValue() + String.valueOf(d.getExp().getYear()));
					}
					d.setIdDet(idDet);
					d.setMvt(mvt);
					try {
						MouvementDetail md = dmvt.save(d);
						String idStk = md.getMag().getCodMag() + "_" + md.getArt().getCodArt();
						if (md.getArt().isPerissable()) {
							idStk += "_" + String.valueOf(md.getExp().getDayOfMonth()) + String
									.valueOf(md.getExp().getMonthValue() + String.valueOf(md.getExp().getYear()));
						}
						Stocker stk = st.findById(idStk).get();
						if (stk == null) {
							stk = new Stocker(idStk,0, 0, md.getArt(), md.getMag());
						}
								st.save(stk);
						if (mvt.getSensMvt() == "Entrée") {
							List<Stocker> stks = st.findByMagArt(md.getMag().getCodMag(), md.getArt().getCodArt());
							if (stks.size()== 0) {
								stk.setCump(md.getPu());
						}
							else {
								double mtt= md.getPu()*md.getQteEnt();
								double den=md.getQteEnt()-md.getQteSor();
								for(Stocker l : stks) {
									mtt+=l.getCump()*l.getQteStk();
									den+=l.getQteStk();
								}
								double cump=mtt/den;
								System.out.print(cump+"stk"+stks.get(0).getIdStk());
								for(Stocker s: stks) {
									s.setCump(cump);
								}
								st.saveAll(stks);
							}
						}
						stk.setQteStk(stk.getQteStk() + md.getQteEnt() - md.getQteSor());
						try {
							st.save(stk);
						} catch (Exception est) {
							System.out.print("erreur ligne stocker: " + est);
							delete(mvt.getNumMvt());
							mvt = null;

						}
					} catch (Exception edet) {
						System.out.print("erreur détail mvt: " + edet);
						delete(mvt.getNumMvt());
						mvt = null;
					}
				}
				if (livree == true) {
					mvt.getCom().setActive(false);
				} else {
					mvt.getCom().setActive(true);
				}
				cr.save(mvt.getCom());

			} catch (Exception emvt) {
				System.out.print("Erreur mvt: " + emvt.getMessage());
				mvt = null;
			}
		} catch (Exception edern) {
			System.out.print(edern.getMessage());
			mvt = null;
		}
		return mvt;
	}

	public void delete(String num) {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
