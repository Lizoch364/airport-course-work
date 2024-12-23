package com.example.airport.viewModel;

import java.util.List;

public record RatingAirlineViewModel(
  BaseViewModel base,
  List<AirlineForRatingViewModel> airlineRating
) {}
