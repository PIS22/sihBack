package sih.securite.services;

import org.springframework.stereotype.Service;

@Service
public class GroupeService {
	/*private final GroupeRepo repo; ////Le repository qui d'action sur la table groupe
	private final AgirRepo aux; ////Le repository qui d'action sur la table agir qui est le mouchard
	
//////////LE constructeur avec paramètre
	public GroupeService(GroupeRepo repo, AgirRepo aux) {
		super();
		this.repo = repo;
		this.aux = aux;
	}

	/////////////////La fonction d'insertion d'un groupe (Elle prend en parametre le groupe à insérer et l'utilisateur qui veut l'insérer)
	public Groupe insert(Groupe elt,Utilisateur us) {
		Groupe nouveau= repo.save(elt);/// Récupération du groupe inséré
		if(!nouveau.equals(null)) { /////Vérification de la bonne finalité de l'insertion
			Agir act=new Agir();///// Création de l'occurence à enrégistrer dans le mouchard
			act.setNouvellesValeurs(nouveau.element());////Initialisation des valeurs du groupe inséré
			act.setDatActe(LocalDateTime.now());///Initialisation de la date de l'insertion
			act.setTable();/////Initialisation de l'objet (table) concerné par l'action  
			act.setUser(us); ///Initialisation de l'auteur de l'insertion
			act.setAction("Ajout");////Mention de l'action effectuée par l'utilisateur
			aux.save(act);/////Alimentation du mouchard (enregistrement de l'activité de l'utilisateur)
			return nouveau;
		}
		return null;
	}
	
	/////Fonction de modification d'un groupe
	public Groupe edit(Groupe elt,Utilisateur us) {
		Groupe ancien=repo.findById(elt.getIdGpe()).get();////////Récupération de l'existant ayant l'id envoyé
		Groupe nouveau= repo.save(elt);////Modification et récupération 
		if(!nouveau.equals(null)) {/////Vérification de l'effectivité de la modification
			Agir act=new Agir();/////Création d'un objet de type Agir
			act.setAnciennesValeurs(ancien.element());///Initialisation des anciennes valeurs
			act.setNouvellesValeurs(nouveau.element());////Initialisation des nouvelles valeurs
			act.setDatActe(LocalDateTime.now());/////Initialisation de la date et l'heur de la modification
			act.setTable("Groupe");/////Identification de la table concernée par l'action
			act.setUser(us);///Initialisation de l'utilisateur ayant réalisé l'opération
			act.setAction("Modification");////Initialisation de l'action de l'utilisateur 
			aux.save(act);////Enrégistrement de laction de l'utilisateur
			return nouveau;
		}
		return null;
	}
	
	
	//////Fonstion de suppression (Elle prend en paramètre l'idetifiant de l'élément à supprimer et l'utilisateur qui fait la suppression
	public void delete(int id,Utilisateur us) {
		Groupe ancien=repo.findById(id).get();////Récupération de l'élément à supprimer
		if(!ancien.equals(null)) {/////Vérification de son existence
			repo.deleteById(id);///Suppression de l'élément concerné
			if(!repo.existsById(id)) {///Vérification de l'effectivité de la suppression
				Agir act=new Agir();/////Création de l'action de l'utilisateur
				act.setAnciennesValeurs(ancien.element());//Initialisation des dernieres valeurs de l'occurrence supprimée
				act.setDatActe(LocalDateTime.now());//Initialisation de la date et l'heure de la suppression
				act.setTable("Groupe");/////Identification de la table cible
				act.setUser(us);///Initialisation de l'auteur de la suppresion
				act.setAction("Supression");////Mention de l'action de uppression
				aux.save(act);////Enrégistrement de l'activité de suppression
			}
		}
	}
	
	
	////Listing
	public List<Groupe> list(){
		return repo.findAll();
	}
	
	
	////Recherche d'un éément suivant son identifiant
	public Groupe select(int id) {
		return repo.findById(id).get();
	}
*/
}
