package sih.securite.config;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import sih.securite.entities.Utilisateur;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authMan;

	public JwtAuthenticationFilter(AuthenticationManager authMan) {
		this.authMan = authMan;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		Utilisateur user = null;
		try {
			user = new ObjectMapper().readValue(request.getInputStream(), Utilisateur.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		UsernamePasswordAuthenticationToken tok = new UsernamePasswordAuthenticationToken(user.getLogin(),
				user.getPass());
		return authMan.authenticate(tok);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		User spgUser = (User) authResult.getPrincipal();
		String jwtToken = Jwts.builder().setSubject(spgUser.getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.exp))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.monSecret)
				.claim("roles", spgUser.getAuthorities()).compact();
		response.addHeader(SecurityConstants.Header, SecurityConstants.prefix + jwtToken);
	}

}
