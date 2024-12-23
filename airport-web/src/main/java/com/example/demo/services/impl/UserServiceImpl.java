package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.domain.enums.UserRole;
import com.example.demo.dto.user.UserCreateDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.dto.user.UserUpdateDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;

@Service
// @EnableCaching
public class UserServiceImpl implements UserService{
  private UserRepository userRepository;

  private ModelMapper modelMapper;

  @Override
  // @Cacheable("users")
  public List<UserDto> findAll() {
    return userRepository.findAll().stream().map(user -> modelMapper.map(user, UserDto.class)).toList();
  }

  @Override
  public UserDto findById(int id) {
    var user = userRepository.findById(id);

    if (user.isEmpty()) {
      throw new RuntimeException("Пользователь с  id = " + id + " не найден");
    }

    return modelMapper.map(user.get(), UserDto.class);
  }

  @Override
  // @Caching(evict = @CacheEvict(cacheNames = "users", allEntries = true))

  public UserDto create(UserCreateDto userCreateDto) {
    User user = new User(
      userCreateDto.getSurname(),
      userCreateDto.getName(),
      userCreateDto.getLastName(),
      userCreateDto.getBirthDate(),
      userCreateDto.getLogin(),
      userCreateDto.getPassword());

    if (user.getLogin().contains("admin")) {
      user.setUserRole(UserRole.Admin);
    } else {
      user.setUserRole(UserRole.User);
    }

    userRepository.save(user);

    return modelMapper.map(user, UserDto.class);
  }

  @Override
  // @Caching(evict = {
  //   @CacheEvict(cacheNames = "users", allEntries = true),
  //   @CacheEvict(cacheNames = "tickets", allEntries = true)
  // })

  public UserDto update(UserUpdateDto userUpdateDto) {
    Optional<User> user = userRepository.findById(userUpdateDto.getId());

    if (user.isEmpty()) {
      throw new RuntimeException("Пользователь с id = " + userUpdateDto.getId() + " не найден");
    }

    User updatedUser = user.get();

    updatedUser.setSurname(userUpdateDto.getSurname());
    updatedUser.setName(userUpdateDto.getName());
    updatedUser.setLastName(userUpdateDto.getLastName());
    updatedUser.setBirthDate(userUpdateDto.getBirthDate());
    updatedUser.setLogin(userUpdateDto.getLogin());

    userRepository.save(updatedUser);

    return modelMapper.map(updatedUser, UserDto.class);
  }

  @Override
  public UserDto findByLogin(String login) {
    var user =  userRepository.findByLogin(login);

    if (user.isEmpty()) {
      throw new RuntimeException("Пользователь с логином = " + login + " не найден");
    }

    return modelMapper.map(user.get(), UserDto.class);
  }

  @Autowired
  public void setUserRepository(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Autowired
  public void setModelMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }
}
