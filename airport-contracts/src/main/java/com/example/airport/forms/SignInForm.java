package com.example.airport.forms;

import jakarta.validation.constraints.NotBlank;

public record SignInForm(
  @NotBlank(message = "Логин обязателен") String login,
  @NotBlank(message = "Пароль обязателен") String password
) {}
