package com.springsecurity.websecmon.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.websecmon.model.CustomUserDetails;
import com.springsecurity.websecmon.model.Users;
import com.springsecurity.websecmon.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UsersRepository usersRepository;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> optionalUsers = usersRepository.findByName(username);
		
		optionalUsers.orElseThrow(()-> new UsernameNotFoundException("Not found User"));
		
		return optionalUsers.map(CustomUserDetails::new).get();
	}

}
