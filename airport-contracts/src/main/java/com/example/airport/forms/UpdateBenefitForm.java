package com.example.airport.forms;

import jakarta.validation.constraints.NotBlank;

public record UpdateBenefitForm(
  @NotBlank(message = "Категория для скидки обязательно") Benefit benefit
) {}

class Benefit{}
