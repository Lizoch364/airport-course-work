package com.example.demo;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Airline;
import com.example.demo.domain.Airport;
import com.example.demo.domain.Flight;
import com.example.demo.domain.User;
import com.example.demo.domain.enums.UserRole;
import com.example.demo.dto.user.UserRegistrationDto;
import com.example.demo.repository.AirlineRepository;
import com.example.demo.repository.AirportRepository;
import com.example.demo.repository.FlightRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserAuthService;

@Component
public class ConsoleRunner implements CommandLineRunner {
  private UserRepository userRepository;
  private FlightRepository flightRepository;
  private AirportRepository airportRepository;
  private AirlineRepository airlineRepository;
  private UserAuthService userAuthService;

  @Autowired
  public ConsoleRunner(UserRepository userRepository, FlightRepository flightRepository, AirportRepository airportRepository, AirlineRepository airlineRepository, UserAuthService userAuthService) {
    this.userRepository = userRepository;
    this.flightRepository = flightRepository;
    this.airportRepository = airportRepository;
    this.airlineRepository = airlineRepository;
    this.userAuthService = userAuthService;
  }

  @Override
  public void run(String... args) throws Exception {
    // User user = new User("фамилия", "имя",  "отчество",  LocalDate.now(), "login", "password");
    // userRepository.save(user);
    // Airport departureAirport = new Airport("name1", "city1");
    // Airport arrivalAirport = new Airport("name2", "city2");
    // airportRepository.save(departureAirport);
    // airportRepository.save(arrivalAirport);

    // Airline airline = new Airline("airline");
    // airlineRepository.save(airline);

    // Flight flight = new Flight("flight", LocalDate.of(2023, 11, 15), LocalDate.of(2023, 11, 15), departureAirport, arrivalAirport, airline, 200, 1200);
    // flightRepository.save(flight);

    // User user = new User("admin", "admin",  "admin",  LocalDate.now(), "admin", "admin");
    // userRepository.save(user);
    // user.setUserRole(UserRole.Admin);
    // UserRegistrationDto userDto = new UserRegistrationDto(
    //   "admin",
    //   "admin",
    //   "admin",
    //   LocalDateTime.of(2000, 06, 06, 0, 0, 0),
    //   "admin",
    //   "admin",
    //   "admin"
    // );

    // userAuthService.register(userDto);
    // var user = userRepository.findByLogin("Lizoch364").orElseThrow(() -> new RuntimeException("Пользователь не найден"));
    // user.setUserRole(UserRole.Admin);
    // userRepository.save(user);
  }
}
