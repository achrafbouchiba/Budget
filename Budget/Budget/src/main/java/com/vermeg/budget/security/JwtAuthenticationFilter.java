package com.vermeg.budget.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vermeg.budget.entities.Contact;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Configuration
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	@Value("${jwt.header}")
	private String header;
	@Value("${jwt.signing-key}")
	private String key;
	@Value("${jwt.prefix-token}")
	private String prefix;
	@Value("${jwt.exp-time}")
	private long expiration;

	@Autowired
	@Override
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		// TODO Auto-generated method stub
		super.setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		Contact contact = null;
		try {
			contact = mapper.readValue(request.getInputStream(), Contact.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getAuthenticationManager()
				.authenticate(new UsernamePasswordAuthenticationToken(contact.getUsername(), contact.getPassword()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// TODO Auto-generated method stub
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authResult.getAuthorities().forEach(authoritiy -> {
			authorities.add(new SimpleGrantedAuthority(authoritiy.getAuthority()));
		});
		String token = Jwts.builder().setSubject(authResult.getName()).claim("roles", authorities)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() +expiration))
				.signWith(SignatureAlgorithm.HS512, key.getBytes())

				.compact();
		response.addHeader(header, prefix + token);
	}
}
