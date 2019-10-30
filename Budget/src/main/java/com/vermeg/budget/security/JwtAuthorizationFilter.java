package com.vermeg.budget.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Configuration
public class JwtAuthorizationFilter extends OncePerRequestFilter {

	@Value("${jwt.signing-key}")
	private String key;
	@Value("${jwt.prefix-token}")
	private String prefix;
	@Value("${jwt.header}")
	private String header;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		
			String header = request.getHeader(this.header);

			// 2. validate the header and check the prefix
			if (header == null || !header.startsWith(prefix)) {
				chain.doFilter(request, response); // If not valid, go to the next filter.
				return;
			}
			// If there is no token provided and hence the user won't be authenticated.
			// It's Ok. Maybe the user accessing a public path or asking for a token.

			// All secured paths that needs a token are already defined and secured in
			// config class.
			// And If user tried to access without access token, then he won't be
			// authenticated and an exception will be thrown.

			// 3. Get the token
			String token = header.replace(prefix, "");

			try { // exceptions might be thrown in creating the claims if for example the token is
					// expired

				// 4. Validate the token
				Claims claims = Jwts.parser().setSigningKey(key.getBytes()).parseClaimsJws(token).getBody();

				String username = claims.getSubject();
				if (username != null) {
					@SuppressWarnings("unchecked")
					List<Map<String, String>> roles = (List<Map<String, String>>) claims.get("roles");

					// 5. Create auth object
					// UsernamePasswordAuthenticationToken: A built-in object, used by spring to
					// represent the current authenticated / being authenticated user.
					// It needs a list of authorities, which has type of GrantedAuthority interface,
					// where SimpleGrantedAuthority is an implementation of that interface

					Collection<GrantedAuthority> authorities = new ArrayList<>();
					roles.forEach(role ->

					{
						
						authorities.add(new SimpleGrantedAuthority(role.get("authority")));
					});

					UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null,
							authorities);

					// 6. Authenticate the user
					// Now, user is authenticated
					SecurityContextHolder.getContext().setAuthentication(auth);
				}

			} catch (Exception e) {
				// In case of failure. Make sure it's clear; so guarantee user won't be
				// authenticated
				e.printStackTrace();
				SecurityContextHolder.clearContext();
			}

			// go to the next filter in the filter chain
			chain.doFilter(request, response);
		}

	
}
