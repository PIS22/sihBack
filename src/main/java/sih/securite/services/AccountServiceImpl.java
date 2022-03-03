package sih.securite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sih.securite.entities.AppRole;
import sih.securite.entities.Utilisateur;
import sih.securite.repositories.RoleRepo;
import sih.securite.repositories.UtilisateurRepo;
import sih.securite.repositories.userAccount;

@Service
@Transactional
public class AccountServiceImpl implements userAccount{
	@Autowired
	private BCryptPasswordEncoder encryptPass;
	@Autowired
	private UtilisateurRepo ur;
	@Autowired
	private RoleRepo rr;

	@Override
	public Utilisateur saveUser(Utilisateur u) {
		u.setPass(encryptPass.encode(u.getPass()));
		return ur.save(u);
	}

	@Override
	public AppRole saveRole(AppRole r) {
		return rr.save(r);
	}

	@Override
	public Utilisateur findByLogin(String log) {
		return ur.findByLogin(log);
	}

	@Override
	public void affectRoleToUser(String usName, String roleName) {
		Utilisateur u= ur.findByLogin(usName);
		u.getRoles().add(rr.findByNomRole(roleName));
	}

}
