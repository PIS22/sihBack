package sih.securite.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import sih.securite.repositories.UtilisateurRepo;

public class JWTAuthorizationFilter extends OncePerRequestFilter{
	@Autowired
	public UtilisateurRepo us;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "*");
		response.addHeader("Access-Control-Allow-Headers", 
				"Origin, Accept, X-Requested-With, Content-Type, "
				+ "Access-Control-Request-Method, " + 
						"Access-Control-Request-Headers, " +
				"Authorization");

		response.addHeader("Access-Control-Expose-Headers",
				"Access-Control-Allow-Origin, "
				+ "Access-Control-Allow-Credentials, " 
				+ "Authorization");
			String jwt = request.getHeader(SecurityConstants.Header);
		if (request.getMethod().equals("OPTIONS")) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {

			if (jwt == null || !jwt.startsWith(SecurityConstants.prefix)) {
				filterChain.doFilter(request, response);
				return;
			} 
				Claims claim = Jwts.parser().setSigningKey(SecurityConstants.monSecret)
						.parseClaimsJws(jwt.replaceAll(SecurityConstants.prefix, "")).getBody();
				String login = claim.getSubject();
				
				@SuppressWarnings("unchecked")
				ArrayList<Map<String, String>> roles = (ArrayList<Map<String, String>>) claim.get("roles");
				Collection<GrantedAuthority> authorities = new ArrayList<>();
				roles.forEach(r -> {
					authorities.add(new SimpleGrantedAuthority(r.get("authority")));
				});
				UsernamePasswordAuthenticationToken log = new UsernamePasswordAuthenticationToken(login, null,
						authorities);
				SecurityContextHolder.getContext().setAuthentication(log);
				filterChain.doFilter(request, response);
		}

	}
	
	

}
