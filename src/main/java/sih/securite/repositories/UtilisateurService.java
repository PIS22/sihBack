package sih.securite.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sih.securite.entities.Agir;
import sih.securite.entities.AppRole;
import sih.securite.entities.Domaine;
import sih.securite.entities.Groupe;
import sih.securite.entities.Objet;
import sih.securite.entities.UserGroup;
import sih.securite.entities.Utilisateur;

@Service
@Transactional
public class UtilisateurService {
	@Autowired
	BCryptPasswordEncoder bcryptPass;
	@Autowired
	private UtilisateurRepo repo;
	@Autowired
	private AgirRepo aux;
	@Autowired
	private UserGroupRepo ugRepo;
	@Autowired
	private GroupeRepo gRepo;
	@Autowired
	private DomaineRepo dRepo;
	@Autowired
	private ObjetRepo orepo;
	@Autowired
	private RoleRepo rrepo;

	public Utilisateur insertUser(Utilisateur elt) {
		if (repo.findByLogin(elt.getLogin()) != null)
			throw new RuntimeException("Le login choisi existe déja");
		Utilisateur use = new Utilisateur();
		use.setPass(bcryptPass.encode(elt.getPass()));
		use.setLogin(elt.getLogin());
		Utilisateur nouveau = repo.save(use);
		return nouveau;
	}

	public Utilisateur register(Utilisateur us) {
		if (repo.findByLogin(us.getLogin()) != null)
			throw new RuntimeException("Le login choisi existe déja");
		us.setPass(bcryptPass.encode(us.getPass()));
		return repo.save(us);
	}

	public Utilisateur editUser(Utilisateur elt, Utilisateur us) {
		elt.setPass(bcryptPass.encode(elt.getPass()));
		Utilisateur ancien = repo.findById(elt.getIdUser()).get();
		Utilisateur nouveau = repo.save(elt);
		if (!nouveau.equals(null)) {
			try {
				Agir act = new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setNouvellesValeurs(nouveau.element());
				act.setDatActe(LocalDateTime.now());
				act.setTable(orepo.findById("Utilisateur").get());
				act.setUser(us);
				act.setAction("Modification");
				aux.save(act);
				return nouveau;
			} catch (Exception e) {
				System.out.print(e.getMessage());
				return null;
			}
		}
		return null;
	}

	public void deleteUser(Long id, Utilisateur us) {
		Utilisateur ancien = repo.findById(id).get();
		if (!ancien.equals(null)) {
			repo.deleteById(id);
			if (!repo.existsById(id)) {
				Agir act = new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setTable(orepo.findById("Utilisateur").get());
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}

	public List<Utilisateur> listUser() {
		return repo.findAll();
	}

	public Utilisateur selectUser(Long id) {
		return repo.findById(id).get();
	}

	public Utilisateur findByLogin(String login) {
		return repo.findByLogin(login);
	}
	
	public void affectRoleToUser(Utilisateur us, AppRole role) {
		us.getRoles().add(role);
	}

///////////////Gestion des groupes utilisateur
	public AppRole insertRole(AppRole elt) {
		try {
			return rrepo.save(elt);
		} catch (Exception e) {
			System.out.print(e.getMessage());
			return null;
		}
		
	}

	public AppRole editRole(AppRole elt) {

		return rrepo.save(elt);
	}

	public void deleteRole(int id) {
		rrepo.deleteById(id);
	}

	public List<AppRole> listRole() {
		return rrepo.findAll();
	}

	public AppRole selectRole(int id) {
		return rrepo.findById(id).get();
	}

	public AppRole findByNomRole(String nomRole) {
		return rrepo.findByNomRole(nomRole);
	}
///////////////Gestion des groupes utilisateur
	public UserGroup insertUserGroup(UserGroup elt, Utilisateur us) {
		UserGroup nouveau = ugRepo.save(elt);
		if (!nouveau.equals(null)) {
			Agir act = new Agir();
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("UserGroup").get());
			act.setUser(us);
			act.setAction("Ajout");
			aux.save(act);
			return nouveau;
		}
		return null;
	}

	public UserGroup editUserGroup(UserGroup elt, Utilisateur us) {
		UserGroup ancien = ugRepo.findById(elt.getIdUsGpe()).get();
		UserGroup nouveau = ugRepo.save(elt);
		if (!nouveau.equals(null)) {
			Agir act = new Agir();
			act.setAnciennesValeurs(ancien.element());
			act.setNouvellesValeurs(nouveau.element());
			act.setDatActe(LocalDateTime.now());
			act.setTable(orepo.findById("UserGroup").get());
			act.setUser(us);
			act.setAction("Modification");
			aux.save(act);
			return nouveau;
		}
		return null;
	}

	public void deleteUserGroup(Long id, Utilisateur us) {
		UserGroup ancien = ugRepo.findById(id).get();
		if (!ancien.equals(null)) {
			repo.deleteById(id);
			if (!repo.existsById(id)) {
				Agir act = new Agir();
				act.setAnciennesValeurs(ancien.element());
				act.setDatActe(LocalDateTime.now());
				act.setTable(orepo.findById("UserGroup").get());
				act.setUser(us);
				act.setAction("Supression");
				aux.save(act);
			}
		}
	}

	public List<UserGroup> listUserGroup() {
		return ugRepo.findAll();
	}

	public UserGroup selectUserGroup(Long id) {
		return ugRepo.findById(id).get();
	}

	///////////////// La fonction d'insertion d'un groupe (Elle prend en parametre
	///////////////// le groupe à insérer et l'utilisateur qui veut l'insérer)
	public Groupe insertGroup(Groupe elt, Utilisateur us) {
		Groupe nouveau = gRepo.save(elt);/// Récupération du groupe inséré
		if (!nouveau.equals(null)) { ///// Vérification de la bonne finalité de l'insertion
			Agir act = new Agir();///// Création de l'occurence à enrégistrer dans le mouchard
			act.setNouvellesValeurs(nouveau.element());//// Initialisation des valeurs du groupe inséré
			act.setDatActe(LocalDateTime.now());/// Initialisation de la date de l'insertion
			act.setTable(orepo.findById("UserGroup").get());///// Initialisation de l'objet (table) concerné par
															///// l'action
			act.setUser(us); /// Initialisation de l'auteur de l'insertion
			act.setAction("Ajout");//// Mention de l'action effectuée par l'utilisateur
			aux.save(act);///// Alimentation du mouchard (enregistrement de l'activité de l'utilisateur)
			return nouveau;
		}
		return null;
	}

	///// Fonction de modification d'un groupe
	public Groupe editGroup(Groupe elt, Utilisateur us) {
		Groupe ancien = gRepo.findById(elt.getIdGpe()).get();//////// Récupération de l'existant ayant l'id envoyé
		Groupe nouveau = gRepo.save(elt);//// Modification et récupération
		if (!nouveau.equals(null)) {///// Vérification de l'effectivité de la modification
			Agir act = new Agir();///// Création d'un objet de type Agir
			act.setAnciennesValeurs(ancien.element());/// Initialisation des anciennes valeurs
			act.setNouvellesValeurs(nouveau.element());//// Initialisation des nouvelles valeurs
			act.setDatActe(LocalDateTime.now());///// Initialisation de la date et l'heur de la modification
			act.setTable(orepo.findById("UserGroup").get());///// Identification de la table concernée par l'action
			act.setUser(us);/// Initialisation de l'utilisateur ayant réalisé l'opération
			act.setAction("Modification");//// Initialisation de l'action de l'utilisateur
			aux.save(act);//// Enrégistrement de laction de l'utilisateur
			return nouveau;
		}
		return null;
	}

	////// Fonstion de suppression (Elle prend en paramètre l'idetifiant de
	////// l'élément à supprimer et l'utilisateur qui fait la suppression
	public void deleteGroup(int id, Utilisateur us) {
		Groupe ancien = gRepo.findById(id).get();//// Récupération de l'élément à supprimer
		if (!ancien.equals(null)) {///// Vérification de son existence
			gRepo.deleteById(id);/// Suppression de l'élément concerné
			if (!gRepo.existsById(id)) {/// Vérification de l'effectivité de la suppression
				Agir act = new Agir();///// Création de l'action de l'utilisateur
				act.setAnciennesValeurs(ancien.element());// Initialisation des dernieres valeurs de l'occurrence
															// supprimée
				act.setDatActe(LocalDateTime.now());// Initialisation de la date et l'heure de la suppression
				act.setTable(orepo.findById("UserGroup").get());///// Identification de la table cible
				act.setUser(us);/// Initialisation de l'auteur de la suppresion
				act.setAction("Supression");//// Mention de l'action de uppression
				aux.save(act);//// Enrégistrement de l'activité de suppression
			}
		}
	}

	//// Listing
	public List<Groupe> listGroup() {
		return gRepo.findAll();
	}

	public Objet findObjet(String lib) {
		return orepo.findById(lib).get();
	}
	
	//// Recherche d'un éément suivant son identifiant
	public Groupe selectGroup(int id) {
		return gRepo.findById(id).get();
	}

	public Domaine insertDom(Domaine elt) {
		return dRepo.save(elt);
	}

	public List<Domaine> listDom() {
		return dRepo.findAll();
	}

	public Domaine selectDom(int id) {
		return dRepo.findById(id).get();
	}

	public Objet insertObjet(Objet obj) {
		return orepo.save(obj);
	}

	public Objet selectObjet(String id) {
		return orepo.objetByLib(id);
	}
}
