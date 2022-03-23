package sih.facturation.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sih.facturation.entities.Vente;
import sih.facturation.entities.VenteBloc;
import sih.facturation.entities.VenteDetail;
import sih.facturation.entities.VentePeriode;
import sih.facturation.repositories.VenteDetailRepo;
import sih.facturation.repositories.VenteRepo;


@Service
public class VenteService {

	@Autowired
	VenteDetailRepo detVet;
	private final VenteRepo repo;
	
	
	public VenteService(VenteRepo repo) {
		super();
		this.repo = repo;
	}
	
	public Vente insert(Vente elt) {
		return repo.save(elt);
	}
		// Modification
	public Vente edit(Vente elt) {
		return repo.save(elt);
	}
	
	public void delete(String id) {
			repo.deleteById(id);
	}
	
	public List<Vente> list(){
		return repo.findAll();
	}
	
	public Vente select(String id) {
		return repo.findById(id).get();
	}
	
	public Vente addV(VenteBloc vte) {
		Vente v=repo.dernier(vte.getVte().getExo().getCodExo());
		String num="VTE"+vte.getVte().getExo().getCodExo()+"-";
		if(v == null) {
			vte.getVte().setOrdre(1);
		}
		else {
			vte.getVte().setOrdre(v.getOrdre()+1);
		}
		while(num.length()+String.valueOf(vte.getVte().getOrdre()).length() <13) {
			num+='0';
		}
		vte.getVte().setIdVente(num+vte.getVte().getOrdre());
		try {
			v = repo.save(vte.getVte());
			for(VenteDetail l: vte.getLines()) {
				l.setVte(v);
			}
			detVet.saveAllAndFlush(vte.getLines());
		} catch (Exception e) {
			v= null;
		}
		return v;
	}

	public List<Vente> vetePeriode(VentePeriode p){
		return repo.ventePeriode(p.getDeb(), p.getFin(), p.getUs(), p.getCais());
	}

	public List<VenteDetail> detailVente(String numV){
		return repo.detailVente(numV);
	}


}