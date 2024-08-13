package com.dhyan.dhyancc.security;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserAccountRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserAccount> user = userRepo.findByUsername(username);
		log.info("Login requestd for user {}, isfound:{}", username, user.isPresent());

		UserDetails userDetails = user
				.map(u -> new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(),
						u.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRole()))
								.collect(Collectors.toList())))
				.orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
		log.info("User {} logging in", username);
		return userDetails;
	}

}
