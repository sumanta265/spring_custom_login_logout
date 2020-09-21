package com.security.core.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;

import com.security.core.Entity.UserEntity;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final UserEntity userEntity = userRepository.findUserByUsername(username);
		if (userEntity == null) {
			throw new UsernameNotFoundException(username);
		}
		UserDetails user = User.withUsername(userEntity.getEmail()).password(userEntity.getPassword()).authorities("USER").build();
		return user;
	}
}
