package com.example.demo.controllers;

import java.security.Principal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.airport.controllers.BuyTicketController;
import com.example.airport.forms.BuyTicketForm;
import com.example.airport.viewModel.BuyTicketInfoViewModel;
import com.example.airport.viewModel.BuyTicketViewModel;
import com.example.airport.viewModel.admin.flight.FlightViewModel;
import com.example.airport.viewModel.admin.user.UserViewModel;
import com.example.demo.domain.Benefit;
import com.example.demo.dto.ticket.TicketCreateDto;
import com.example.demo.dto.ticket.TicketDto;
import com.example.demo.services.BenefitService;
import com.example.demo.services.FlightService;
import com.example.demo.services.TicketService;
import com.example.demo.services.UserService;

@Controller
@RequestMapping("/buy-ticket")
public class BuyTicketControllerImpl extends BaseController implements BuyTicketController {
  private TicketService ticketService;
  private UserService userService;
  private FlightService flightService;
  private BenefitService benefitService;

  private ModelMapper modelMapper;

  @Override
  @GetMapping
  public String getBuyTicketPage(
    @RequestParam(name = "f", required = false, defaultValue = "") String flightId,
    Principal principal,
    Model model
    ) {
    var user = modelMapper.map(userService.findByLogin(principal.getName()), UserViewModel.class);

    var flightsAll = flightService.filterAvailableFlight(flightService.findAll());

    var flights = flightsAll.stream().map(f -> modelMapper.map(f, FlightViewModel.class)).toList();

    var viewModel = new BuyTicketViewModel(
      createBaseViewModel("Покупка билета"),
      user,
      flights
    );

    var form = new BuyTicketForm(0);

    if (!flightId.equals("")) {
      var flight = flightService.findById(Integer.parseInt(flightId));

      if (flight != null) {
        var infoViewModel = new BuyTicketInfoViewModel(flight.getId(), user.getId(), modelMapper.map(flight, FlightViewModel.class), 0);

        form.setFlightId(flight.getId());

        Benefit benefit = benefitService.findMaxBenefitByUserId(user.getId());

        if (benefit == null) {
          benefit = new Benefit("empty", 0);
        }

        infoViewModel.setDiscount(benefit.getDiscountMultiplier());
        infoViewModel.setTotalPrice(flight.getPrice() * (1 - benefit.getDiscountMultiplier()));

        model.addAttribute("info", infoViewModel);
      }
    }

    model.addAttribute("model", viewModel);
    model.addAttribute("form", form);

    return "pages/buy-ticket";
  }
  @Override
  @PostMapping
  public String buyTicket( BuyTicketForm buyTicketForm, BindingResult result, Principal principal, Model model) {
    if (result.hasErrors()) {
      var user = modelMapper.map(userService.findByLogin(principal.getName()), UserViewModel.class);
      var flights = flightService.findAll().stream().map(f -> modelMapper.map(f, FlightViewModel.class)).toList();

      var viewModel = new BuyTicketViewModel(
        createBaseViewModel("Покупка билета"),
        user,
        flights
      );

      model.addAttribute("model", viewModel);
      model.addAttribute("form", buyTicketForm);

      return "pages/buy-ticket";
    }

    TicketDto ticket = ticketService.buy(new TicketCreateDto(principal.getName(), buyTicketForm.getFlightId()));

    return "redirect:/tickets";
  }
  @Autowired
  public void setTicketService(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  @Autowired
  public void setFlightService(FlightService flightService) {
    this.flightService = flightService;
  }
  @Autowired
  public void setBenefitService(BenefitService benefitService) {
    this.benefitService = benefitService;
  }

  @Autowired
  public void setModelMapper(ModelMapper modelMapper) {
      this.modelMapper = modelMapper;
  }
}
