package com.example.demo.controllers;

import java.security.Principal;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.airport.controllers.UserContextController;
import com.example.airport.forms.SearchFlightForm;
import com.example.airport.viewModel.HomeViewModel;
import com.example.airport.viewModel.UserTicketViewModel;
import com.example.airport.viewModel.SearchFlightViewModel;
import com.example.airport.viewModel.UserTicketBaseViewModel;
import com.example.airport.viewModel.UserTicketMoreViewModel;
import com.example.airport.viewModel.admin.AdminGetByIdViewModel;
import com.example.airport.viewModel.admin.flight.FlightViewModel;
import com.example.demo.services.FlightService;
import com.example.demo.services.TicketService;
import com.example.demo.services.UserService;

@Controller
public class UserContextControllerImpl extends BaseController implements UserContextController {
  private static final Logger logger = LogManager.getLogger(Controller.class);
  private TicketService ticketService;
  private UserService userService;
  private FlightService flightService;
  private ModelMapper modelMapper;
  @Override
  @GetMapping("/tickets/{id}")
  public String getTicketById(@PathVariable int id, Principal principal, Model model) {
    var ticketViewModel = modelMapper.map(ticketService.findById(id), UserTicketMoreViewModel.class);
    var getTicketById = new AdminGetByIdViewModel<>(
      createBaseViewModel("Билет с id = " + id),
      ticketViewModel
    );

    var user = userService.findByLogin(principal.getName());
    model.addAttribute("user", user);
    model.addAttribute("model", getTicketById);
    return "pages/user-ticket-more";
  }

  @Override
  @GetMapping("/tickets")
  public String allTicketsByUserPage(Principal principal, Model model) {
    List<UserTicketViewModel> tickets = ticketService.findAllByUserLogin(principal.getName()).stream().map(ticket -> modelMapper.map(ticket, UserTicketViewModel.class)).toList();

    var viewModel = new UserTicketBaseViewModel(
      createBaseViewModel("Мои билеты"),
      tickets
    );

    model.addAttribute("model", viewModel);
    return "pages/all-user-tickets";
  }

  @Override
  @PostMapping("tickets/decline/{id}")
  public String decline(@PathVariable int id) {
    ticketService.decline(id);

    return "redirect:/tickets";
  }

  @Override
  @GetMapping("/")
  public String findFlightsPage(Model model) {
    logger.log(Level.INFO, "user admin opened home page");
    var viewModel = new HomeViewModel(
      createBaseViewModel("Поиск рейсов")
    );

    model.addAttribute("model", viewModel);
    model.addAttribute("form", new SearchFlightForm("", ""));

    return "pages/home";
  }

  @Override
  @GetMapping("/flights")
  public String findFlightsByDEpartureAndArrivalAirports(
    SearchFlightForm form,
    BindingResult result,
     Model model) {
    if (result.hasErrors()) {
      var homeViewModel = new HomeViewModel(
        createBaseViewModel("Поиск рейсов")
      );

      model.addAttribute("model", homeViewModel);
      model.addAttribute("form", form);
      return "";
    }

    List<FlightViewModel> flights = flightService.searchFlightByParam(form.departureCity(), form.arrivalCity()).stream().map(flight -> modelMapper.map(flight, FlightViewModel.class)).toList();

    var viewModel = new SearchFlightViewModel(
      createBaseViewModel("Результаты поиска рейсов"),
      flights
    );

    model.addAttribute("model", viewModel);
    model.addAttribute("form", form);

    return "pages/search-flights";
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
  public void setModelMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }
}
