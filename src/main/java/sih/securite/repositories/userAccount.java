package sih.securite.repositories;

import sih.securite.entities.AppRole;
import sih.securite.entities.Utilisateur;

public interface userAccount {
	public Utilisateur saveUser(Utilisateur u);
	public AppRole saveRole(AppRole r);
	public Utilisateur findByLogin(String log);
	public void affectRoleToUser(String usName, String roleName);
	
	

}
