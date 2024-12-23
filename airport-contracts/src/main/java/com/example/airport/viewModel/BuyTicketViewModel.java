package com.example.airport.viewModel;

import java.util.List;

import com.example.airport.viewModel.admin.flight.FlightViewModel;
import com.example.airport.viewModel.admin.user.UserViewModel;

public record BuyTicketViewModel(
  BaseViewModel base,
  UserViewModel user,
  List<FlightViewModel> flights
) {}
