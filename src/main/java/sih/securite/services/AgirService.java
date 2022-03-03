package sih.securite.services;

import org.springframework.stereotype.Service;


@Service
public class AgirService {
	/*private final AgirRepo repo;
	private final AgirRepo aux;

	public AgirService(AgirRepo repo, AgirRepo aux) {
		super();
		this.repo = repo;
		this.aux = aux;
	}

	public Agir insert(Agir elt,Utilisateur us) {
		Agir nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(elt.getClass().getName());
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public Agir edit(Agir elt,Utilisateur us) {
		Agir ancien=repo.findById(elt.getIdActe()).get();
		Agir nouveau= repo.save(elt);
		if(!nouveau.equals(null)) {
			Agir act=new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(elt.getClass().getName());
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}
	
	public void delete(Long id,Utilisateur us) {
		Agir ancien=repo.findById(id).get();
		if(!ancien.equals(null)) {
			repo.deleteById(id);
			if(!repo.existsById(id)) {
				Agir act=new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setTable(ancien.getClass().getName());
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}
	
	public List<Agir> list(){
		return repo.findAll();
	}
	
	public Agir select(Long id) {
		return repo.findById(id).get();
	}

*/
}
