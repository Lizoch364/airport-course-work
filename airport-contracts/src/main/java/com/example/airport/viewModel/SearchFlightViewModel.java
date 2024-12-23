package com.example.airport.viewModel;

import java.util.List;

import com.example.airport.viewModel.admin.flight.FlightViewModel;

public record SearchFlightViewModel(
  BaseViewModel base,
  List<FlightViewModel> flights
) {}


