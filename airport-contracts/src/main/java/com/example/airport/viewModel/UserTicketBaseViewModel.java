package com.example.airport.viewModel;

import java.util.List;

public record UserTicketBaseViewModel (
  BaseViewModel base,
  List<UserTicketViewModel> tickets
){
}
