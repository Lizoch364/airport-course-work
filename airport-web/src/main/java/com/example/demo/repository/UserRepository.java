package com.example.demo.repository;

import java.util.Optional;

import com.example.demo.domain.User;
import com.example.demo.repository.baseRepository.CreateRepository;
import com.example.demo.repository.baseRepository.GetRepository;
import com.example.demo.repository.baseRepository.UpdateRepository;

public interface UserRepository extends CreateRepository<User>, GetRepository<User>, UpdateRepository<User>{
  Optional<User> findByLogin(String login);
}
