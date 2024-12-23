package com.example.demo.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.baseRepository.BaseRepositoryImpl;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {
  public UserRepositoryImpl() {
    super(User.class);
  }
  @Override
  public Optional<User> findByLogin(String login) {
    try {
      return Optional.ofNullable(
        getEntityManager().createQuery(
        "SELECT u FROM User u WHERE u.login = :login",
        User.class)
        .setParameter("login", login)
        .getSingleResult()
        );
    } catch (Exception e) {
      return Optional.empty();
    }
  }
}
