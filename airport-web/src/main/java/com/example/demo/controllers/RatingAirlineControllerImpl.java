package com.example.demo.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.airport.controllers.RatingAirlineController;
import com.example.airport.viewModel.AirlineForRatingViewModel;
import com.example.airport.viewModel.RatingAirlineViewModel;
import com.example.demo.services.AirlineService;

@Controller
@RequestMapping("/rating-airlines")
public class RatingAirlineControllerImpl extends BaseController implements RatingAirlineController {
  private AirlineService airlineService;

  private ModelMapper modelMapper;

  @Override
  @GetMapping("/calculate-rating")
  public String getRatingAirline( String amount, Model model) {
    List<AirlineForRatingViewModel> airlines = airlineService.getTopNAirlinesByRating().stream().map(
      airline -> modelMapper.map(airline, AirlineForRatingViewModel.class)).toList();

      var airlinesRatingViewModel = new RatingAirlineViewModel(
        createBaseViewModel("Рейтинг авиакомпаний"),
        airlines
      );

      model.addAttribute("model", airlinesRatingViewModel);

      return "pages/rating-airlines";
  }

  @Autowired
  public void setAirlineService(AirlineService airlineService) {
    this.airlineService = airlineService;
  }

  @Autowired
  public void setModelMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }
}
