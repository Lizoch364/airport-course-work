package com.example.airport.viewModel.admin;

import java.util.List;

import com.example.airport.viewModel.BaseViewModel;

public record AdminGetAllViewModel<T>(
  BaseViewModel base,
  List<T> values
) {}

