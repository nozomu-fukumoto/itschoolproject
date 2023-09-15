package com.sample.itschoolpg.itschoolproject.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sample.itschoolpg.itschoolproject.entitiy.UserEntity;

public class CustomUserDetails implements UserDetails{
	private final UserEntity user;
	
	public CustomUserDetails(UserEntity user) {
		this.user =user;		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return this.user.password();
	}

	@Override
	public String getUsername() {
		return this.user.username();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
