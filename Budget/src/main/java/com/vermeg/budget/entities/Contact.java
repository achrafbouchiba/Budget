package com.vermeg.budget.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data //Getter and Setter
public class Contact implements Serializable,UserDetails{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private String prenom;
	private String tel;
	private String email;
	private String username;
	private String password;
	private String role;
	@JsonIgnore
	@Transient
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { 
       List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
       authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
	return authorities;
	}
	@JsonIgnore
	@Transient
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@JsonIgnore
	@Transient
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@JsonIgnore
	@Transient
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@JsonIgnore
	@Transient
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
