package sih.compta.services;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import sih.compta.entities.CompteEcriture;
import sih.compta.entities.Ecriture;
import sih.compta.entities.EcritureBlock;
import sih.compta.repositories.CompteEcritureRepository;
import sih.compta.repositories.EcritureRepository;


@Service
public class EcritureService {

	private final EcritureRepository repo;
	private  final CompteEcritureRepository repoL;

	public EcritureService(EcritureRepository repo, CompteEcritureRepository repoL) {
		this.repo = repo;
		this.repoL = repoL;
	}

	public List<Ecriture> getAll(){
		return repo.findAll();
	}
	
	public Ecriture getById(String id) {
		return repo.findById(id).get();
	}
	
	@SuppressWarnings("deprecation")
	public Ecriture add(Ecriture ecriture) {
		int mois= new Date().getMonth()+1;
		String chain;
		if(String.valueOf(mois).length() == 1){
			chain = ecriture.getExo()+"0"+String.valueOf(mois)+ecriture.getJournal().getIdJrn();
		}
		else
			chain = ecriture.getExo().getCodExo()+String.valueOf(mois)+ecriture.getJournal().getIdJrn();

		int ordre=1;
		Ecriture dernier =repo.ordre(ecriture.getExo().getCodExo(),ecriture.getJournal().getIdJrn());
		if(dernier != null){
			ordre = dernier.getOrdre()+1;
		}
		String od= String.valueOf(ordre);
		while (od.length()<4){
			od="0"+od;
		}
		chain+="-"+od;
		System.out.println(chain);
		ecriture.setNumEcri(chain);
		ecriture.setOrdre(ordre);
		ecriture.setValide(true);
		return repo.save(ecriture);
	}
	
	public Ecriture edit(String id, Ecriture ecriture) {
		
		if(repo.existsById(id)) {
			Ecriture entiter = repo.findById(id).get();
			entiter.setDatEcri(ecriture.getDatEcri());
			entiter.setDescipt(ecriture.getDescipt());
			entiter.setExo(ecriture.getExo());
			entiter.setJournal(ecriture.getJournal());
			entiter.setRefExtern(ecriture.getRefExtern());
			entiter.setRefIntern(ecriture.getRefIntern());
			entiter.setValide(ecriture.isValide());
			
			return repo.save(entiter);
		}
		return null;
	}

	public boolean delete (String id) {
		repo.deleteById(id);
		return !repo.existsById(id);
	}

	public Ecriture addEriture(EcritureBlock obj){
		Ecriture e = add(obj.getE());
		if(e.getNumEcri()!=null){
			for(CompteEcriture l : obj.getLines()){
				l.setEcriture(e);
			}
			repoL.saveAll(obj.getLines());
		}
		return e;
	}
	
	public Ecriture editBloc(EcritureBlock obj){
		Ecriture e = edit(obj.getE().getNumEcri(), obj.getE());
		repoL.deleteAll(repoL.linesOf(e.getNumEcri()));
		repoL.saveAll(obj.getLines());
		return e;
	}

}
