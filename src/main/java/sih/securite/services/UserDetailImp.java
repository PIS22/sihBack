package sih.securite.services;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sih.securite.entities.Utilisateur;

@Service
public class UserDetailImp implements UserDetailsService {
	@Autowired
	private AccountServiceImpl as;

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		Utilisateur u=as.findByLogin(arg0);
		if(u==null) throw new UsernameNotFoundException(arg0);
		Collection<GrantedAuthority> authorities=new ArrayList<>();
		u.getRoles().forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.getNomRole()));
		});
		User us=new User(u.getLogin(), u.getPass(), authorities);
		return us;
		
	}
	

}
