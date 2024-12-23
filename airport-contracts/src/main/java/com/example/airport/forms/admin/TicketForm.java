package com.example.airport.forms.admin;

import jakarta.validation.constraints.NotBlank;

public record TicketForm(
  @NotBlank(message = "Пользователь обязателен") int userId,
  @NotBlank(message = "Рейс обязателен") int flightId
) {}
