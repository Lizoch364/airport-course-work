package com.example.demo.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.airport.controllers.admin.AdminFlightController;
import com.example.airport.forms.admin.FlightForm;
import com.example.airport.viewModel.admin.AdminGetAllViewModel;
import com.example.airport.viewModel.admin.AdminGetByIdViewModel;
import com.example.airport.viewModel.admin.airline.AirlineViewModel;
import com.example.airport.viewModel.admin.airport.AirportViewModel;
import com.example.airport.viewModel.admin.flight.FlightCreateViewModel;
import com.example.airport.viewModel.admin.flight.FlightUpdateViewModel;
import com.example.airport.viewModel.admin.flight.FlightViewModel;
import com.example.demo.dto.flight.FlightCreateDto;
import com.example.demo.dto.flight.FlightDto;
import com.example.demo.dto.flight.FlightUpdateDto;
import com.example.demo.services.AirlineService;
import com.example.demo.services.AirportService;
import com.example.demo.services.FlightService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/flights")
public class FlightControllerImpl extends BaseController implements AdminFlightController{
  private FlightService flightService;
  private AirportService airportService;
  private AirlineService airlineService;

  private ModelMapper modelMapper;
  @Override
  @GetMapping()
  public String findAll(Model model) {
    List<FlightViewModel> flightViewModel = flightService
      .findAll()
      .stream()
      .map(flight -> modelMapper.map(flight, FlightViewModel.class))
      .toList();

    var getAllFlightsViewModel = new AdminGetAllViewModel<>(
      createBaseViewModel("Рейсы"),
      flightViewModel
    );

    model.addAttribute("model", getAllFlightsViewModel);

    return "pages/admin/flight/all-flights";
  }

  @Override
  @GetMapping("/{id}")
  public String findById(@PathVariable int id, Model model){
    FlightViewModel flightViewModel = modelMapper.map(flightService.findById(id), FlightViewModel.class);

    var getFlightByIdViewModel = new AdminGetByIdViewModel<FlightViewModel>(
      createBaseViewModel("Рейс " + flightViewModel.getName()),
      flightViewModel
    );

    model.addAttribute("model", getFlightByIdViewModel);

    return "pages/admin/flight/find-one-flight";
  }

  @Override
  @GetMapping("/create")
  public String createForm(Model model) {
    List<AirportViewModel> airports = airportService.findAll()
      .stream()
      .map(airport -> modelMapper.map(airport, AirportViewModel.class))
      .toList();

    List<AirlineViewModel> airlines = airlineService.findAll()
      .stream()
      .map(airline -> modelMapper.map(airline, AirlineViewModel.class))
      .toList();

    var flightCreateViewModel = new FlightCreateViewModel(
      createBaseViewModel("Создание рейса"),
      airports,
      airlines
    );

    model.addAttribute("model", flightCreateViewModel);
    model.addAttribute("form", new FlightForm(null, 0, 0, 0, null, null, 0, 0));

    return "pages/admin/flight/create-flight";
  }

  @Override
  @PostMapping("/create")
  public String create(@Valid FlightForm form, BindingResult result, Model model) {
    if(result.hasErrors()) {
      List<AirportViewModel> airports = airportService.findAll()
      .stream()
      .map(airport -> modelMapper.map(airport, AirportViewModel.class))
      .toList();

      List<AirlineViewModel> airlines = airlineService.findAll()
      .stream()
      .map(airline -> modelMapper.map(airline, AirlineViewModel.class))
      .toList();

      var flightCreateViewModel = new FlightCreateViewModel(
        createBaseViewModel("Создание рейса"),
        airports,
        airlines
      );

      model.addAttribute("model", flightCreateViewModel);
      model.addAttribute("form", form);

      return "pages/admin/flight/create-flight";
    }

    FlightCreateDto flightCreateDto = modelMapper.map(form, FlightCreateDto.class);

    System.out.println(form.getArrivalAirportId());
    System.out.println(flightCreateDto.getArrivalAirportId());

    FlightDto flightDto = flightService.create(flightCreateDto);

    return "redirect:/admin/flights/" + flightDto.getId();
  }

  @Override
  @GetMapping("/update/{id}")
  public String editForm(@PathVariable int id, Model model){
    List<AirportViewModel> airports = airportService.findAll()
      .stream()
      .map(airport -> modelMapper.map(airport, AirportViewModel.class))
      .toList();

    List<AirlineViewModel> airlines = airlineService.findAll()
      .stream()
      .map(airline -> modelMapper.map(airline, AirlineViewModel.class))
      .toList();

    FlightForm flightForm = modelMapper.map(flightService.findById(id), FlightForm.class);
    System.out.println("DATA!!!!");
    System.out.println(flightForm.getDeparture());
    System.out.println(flightForm.getArrival());

    var updateViewModel = new FlightUpdateViewModel(
      createBaseViewModel("Обновление рейса"),
      airports,
      airlines
    );

    model.addAttribute("model", updateViewModel);
    model.addAttribute("form", flightForm);

    return "pages/admin/flight/update-flight";
  }

  @Override
  @PostMapping("/update/{id}")
  public String update(@PathVariable int id, @Valid FlightForm form, BindingResult result, Model model) {
    List<AirportViewModel> airports = airportService.findAll()
      .stream()
      .map(airport -> modelMapper.map(airport, AirportViewModel.class))
      .toList();

    List<AirlineViewModel> airlines = airlineService.findAll()
      .stream()
      .map(airline -> modelMapper.map(airline, AirlineViewModel.class))
      .toList();

    if(result.hasErrors()) {
      var updateViewModel = new FlightUpdateViewModel(
        createBaseViewModel("Обновление рейса"),
        airports,
        airlines
      );

      model.addAttribute("model", updateViewModel);
      model.addAttribute("form", form);

      return "pages/admin/flight/update-flight";
    }

    FlightUpdateDto flightUpdateDto = modelMapper.map(form, FlightUpdateDto.class);
    flightService.update(flightUpdateDto);
    return "redirect:/admin/flights/" + id;
  }

  @Autowired
  public void setFlightService(FlightService flightService) {
    this.flightService = flightService;
  }

  @Autowired
  public void setModelMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  @Autowired
  public void setAirlineService(AirlineService airlineService) {
    this.airlineService = airlineService;
  }

  @Autowired
  public void setAirportService(AirportService airportService) {
    this.airportService = airportService;
  }
}
