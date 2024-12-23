package com.example.demo.services.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.domain.enums.UserRole;
import com.example.demo.dto.user.UserDto;
import com.example.demo.dto.user.UserRegistrationDto;
import com.example.demo.dto.user.UserUpdatePasswordDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserAuthService;

@Service
public class UserAuthServiceImpl implements UserAuthService{
  private UserRepository userRepository;

  private PasswordEncoder passwordEncoder;

  private ModelMapper modelMapper;

  @Override
  // @Caching(evict = @CacheEvict(cacheNames = "users", allEntries = true))
  public void register(UserRegistrationDto userDto) {
    if (!userDto.getPassword().equals(userDto.getConfirmPassword())) {
      throw new RuntimeException("Пароли должны совпадать");
    }

    Optional<User> userByLogin = userRepository.findByLogin(userDto.getLogin());

    if (userByLogin.isPresent()) {
      throw new RuntimeException("Пользователь с таким логином уже существует");
    }

    User user = new User (
      userDto.getSurname(),
      userDto.getName(),
      userDto.getLastName(),
      userDto.getBirthDate(),
      userDto.getLogin(),
      passwordEncoder.encode(userDto.getPassword())
    );

    user.setUserRole(UserRole.User);

    userRepository.save(user);
  }

  @Override
  public UserDto getUser(String login) {
    return modelMapper.map(userRepository.findByLogin(login).orElseThrow(() -> new RuntimeException("Пользователь с логином " + login + " не найден")),
      UserDto.class
    );
  }

  @Override
  // @Caching(evict = @CacheEvict(cacheNames = "users", allEntries = true))
  public UserDto updatePassword(UserUpdatePasswordDto dto) {
    var user = userRepository.findById(dto.getUserId()).get();

    if (!dto.getNewPassword().equals(dto.getConfirmPassword())) {
      throw new RuntimeException("Пароли должны совпадать");
    }

    user.setPassword(passwordEncoder.encode(dto.getNewPassword()));

    return modelMapper.map(userRepository.save(user), UserDto.class);
  }

  @Autowired
  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  @Autowired
  public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Autowired
  public void setModelMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }
}
