package br.com.project.security;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.project.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {

	static final String SECRET = "MySecret";
	static final String TOKEN_PREFIX = "Bearer";
	static final String HEADER_STRING = "Authorization";

	static ObjectMapper mapper = new ObjectMapper();

	/**
	 * Metodo de adição de autenticação
	 * 
	 * @author erick.oliveira
	 * @param response
	 * @param username
	 * @param collection
	 * @throws IOException
	 */
	public String addAuthentication(HttpServletResponse response, User user, String authorities,Boolean isAdm) throws IOException {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("roles", authorities);
		user.setPassword("");
		claims.put("user", user);

		String JWT = Jwts.builder().setSubject(user.getId().toString()).setClaims(claims)
				.setExpiration(getExpirationTime(isAdm))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		
		
		response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
		if (JWT != null) {
			return TOKEN_PREFIX + " " + JWT;
		}
		return "";
	}

	private Date getExpirationTime(Boolean isAdm) {
		int days =  isAdm ? 1 : 60;
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_WEEK, days);
		return calendar.getTime();
	}
	
	
	/**
	 * Recuperar autenticação partir do token
	 * 
	 * @author erick.oliveira
	 * @param request
	 * @return
	 */
	public static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);
		if (token != null) {
			Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
					.getBody();
			List<GrantedAuthority> grantedAuths = AuthorityUtils
					.commaSeparatedStringToAuthorityList((String) claims.get("roles"));
			if (claims != null) {
				return new UsernamePasswordAuthenticationToken(claims.get("user"), null, grantedAuths);
			}
		}
		return null;
	}

	public static User getUserPrincipal() {
		final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication.getPrincipal() != null) {
			User user = mapper.convertValue(authentication.getPrincipal(), User.class);
			return user;
		}
		;
		return null;
	}

}
