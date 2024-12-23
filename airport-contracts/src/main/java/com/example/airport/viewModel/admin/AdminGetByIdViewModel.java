package com.example.airport.viewModel.admin;

import com.example.airport.viewModel.BaseViewModel;

public record AdminGetByIdViewModel<T>(
  BaseViewModel base,
  T value
) {}
