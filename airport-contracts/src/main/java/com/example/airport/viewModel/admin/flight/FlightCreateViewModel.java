package com.example.airport.viewModel.admin.flight;

import java.util.List;

import com.example.airport.viewModel.BaseViewModel;
import com.example.airport.viewModel.admin.airline.AirlineViewModel;
import com.example.airport.viewModel.admin.airport.AirportViewModel;

public record FlightCreateViewModel(
  BaseViewModel base,
  List<AirportViewModel> airports,
  List<AirlineViewModel> airlines
) {
}
