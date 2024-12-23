package com.example.demo.services;

import com.example.demo.dto.user.UserDto;
import com.example.demo.dto.user.UserRegistrationDto;
import com.example.demo.dto.user.UserUpdatePasswordDto;

public interface UserAuthService {
  public void register(UserRegistrationDto userDto);
  public UserDto getUser(String login);
  public UserDto updatePassword(UserUpdatePasswordDto updatePassword);
}
