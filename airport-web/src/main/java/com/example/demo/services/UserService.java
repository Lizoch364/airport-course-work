package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.user.UserCreateDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.dto.user.UserUpdateDto;

public interface UserService {
  List<UserDto> findAll();
  UserDto findById(int id);
  UserDto findByLogin(String login);
  UserDto create(UserCreateDto user);
  UserDto update(UserUpdateDto user);
}
