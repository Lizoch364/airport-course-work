package com.example.demo.utils;

import java.util.Comparator;

import com.example.demo.dto.airline.RatingAirlineDto;

public class RatingAirlineComparator implements Comparator<RatingAirlineDto>{

  @Override
  public int compare(RatingAirlineDto left, RatingAirlineDto right) {
    int result = right.getCountTicket() - left.getCountTicket();
    if (result == 0) {
      result = right.getName().compareTo(left.getName());
    }

    return result;
  }
}
