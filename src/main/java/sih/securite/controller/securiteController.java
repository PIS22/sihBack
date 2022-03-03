package sih.securite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import sih.securite.entities.AppRole;
import sih.securite.entities.Disposer;
import sih.securite.entities.DisposerBlock;
import sih.securite.entities.Groupe;
import sih.securite.entities.GroupeBlock;
import sih.securite.entities.UserGroup;
import sih.securite.entities.UserGroupeBlock;
import sih.securite.entities.Utilisateur;
import sih.securite.entities.UtilisateurBlock;
import sih.securite.repositories.UtilisateurService;
import sih.securite.services.DisposerService;

@CrossOrigin
@RequestMapping("/")
public class securiteController {
@Autowired
private UtilisateurService use;
@Autowired
private DisposerService dis;


///////////////Actions sur utilisateur
@PostMapping("login")
public Utilisateur connexion(@RequestBody Utilisateur u){
	//System.out.print("Tentative de connexion");
	return use.findByLogin(u.getLogin());
}
@GetMapping("securite/us/list")
public List<Utilisateur> listUser(){
	return use.listUser();
}

@GetMapping("securite/us/byId/{id}")
public Utilisateur findUser(@PathVariable(name = "id") Long id) {
	return use.selectUser(id);
}

@PostMapping("register")
Utilisateur addingUser(@RequestBody Utilisateur us){
	if(use.findByLogin(us.getLogin())!=null) 
		throw new RuntimeException("Le login choisi existe déja");
	Utilisateur nUser=new Utilisateur();
	nUser.setPass(us.getPass());
	nUser.setLogin(us.getLogin());
	return use.register(nUser);
}

@PutMapping("securite/us/list")
public Utilisateur editingUser(@RequestBody UtilisateurBlock us) {
	return use.editUser(us.getUser(), us.getAuteur());
}

@DeleteMapping("securite/us/list")
public void deletingUser(UtilisateurBlock us) {
	use.deleteUser(us.getUser().getIdUser(), us.getAuteur());
}


/////////Interaction sur le groupes
@GetMapping("securite/gpe/list")
public List<Groupe> listGroupe(){
	return use.listGroup();
}

@GetMapping("securite/gpe/byId/{id}")
public Groupe findGroupe(@PathVariable(name = "id") int id) {
	return use.selectGroup(id);
}

@PostMapping("securite/gpe/list")
Groupe addingGroupe(@RequestBody GroupeBlock bloc){
	return use.insertGroup(bloc.getGpe(), bloc.getAuteur());
}

@PutMapping("securite/gpe/list")
public Groupe editingGroupe(@RequestBody GroupeBlock bloc) {
	return use.editGroup(bloc.getGpe(), bloc.getAuteur());
}

@DeleteMapping("securite/gpe/list")
public void deletingGroupe(GroupeBlock bloc) {
	use.deleteGroup(bloc.getGpe().getIdGpe(), bloc.getAuteur());
}

//////////////Interaction sur le groupes
@GetMapping("securite/role/list")
public List<AppRole> listRole(){
return use.listRole();
}

@GetMapping("securite/role/byId/{id}")
public AppRole findRole(@PathVariable(name = "id") int id) {
return use.selectRole(id);
}

@PostMapping("securite/role/list")
AppRole addingRole(@RequestBody AppRole elt){
return use.insertRole(elt);
}

@PutMapping("securite/role/list")
public AppRole editingAppRole(@RequestBody AppRole elt) {
return use.editRole(elt);
}

@DeleteMapping("securite/role/list")
public void deletingRole(int id) {
use.deleteRole(id);
}


//////////////Interaction sur le association utilisateur-groupe
@GetMapping("securite/ug/list")
public List<UserGroup> listUserGroupe(){
	return use.listUserGroup();
}

@GetMapping("securite/ug/byId/{id}")
public UserGroup findUserGroupe(@PathVariable(name = "id") Long id) {
	return use.selectUserGroup(id);
}

@PostMapping("securite/ug/list")
UserGroup addingUserGroupe(@RequestBody UserGroupeBlock bloc){
	return use.insertUserGroup(bloc.getUseGroup(), bloc.getAuteur());
}

@PutMapping("securite/ug/list")
public UserGroup editingUserGroupe(@RequestBody UserGroupeBlock bloc) {
	return use.editUserGroup(bloc.getUseGroup(), bloc.getAuteur());
}

@DeleteMapping("securite/ug/list")
public void deletingUserGroupe(UserGroupeBlock bloc) {
	use.deleteUserGroup(bloc.getUseGroup().getIdUsGpe(), bloc.getAuteur());
}



//////////////Interaction sur le association groupe-Droit-Objet
@GetMapping("dis/list")
public List<Disposer> listDisposer(){
	return dis.list();
}

@GetMapping("dis/byId/{id}")
public Disposer findDisposer(@PathVariable(name = "id") Long id) {
	return dis.select(id);
}

@PostMapping("dis/list")
Disposer addingDisposer(@RequestBody DisposerBlock bloc){
	return dis.insert(bloc.getDisposer(), bloc.getAuteur());
}

@PutMapping("dis/list")
public Disposer editingDisposer(@RequestBody DisposerBlock bloc) {
	return dis.edit(bloc.getDisposer(), bloc.getAuteur());
}

@DeleteMapping("dis/list")
public void deletingDisposer(DisposerBlock bloc) {
	dis.delete(bloc.getDisposer().getIdDis(), bloc.getAuteur());
}

}
