package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{
  private UserRepository userRepository;

  public UserDetailsServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    List<SimpleGrantedAuthority> roles = new ArrayList<>();
    var user = userRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("User not found: " + login));

    roles.add(new SimpleGrantedAuthority("ROLE_" +  user.getUserRole().name()));

    return new User(
      user.getLogin(),
      user.getPassword(),
      roles
    );
  }
}
