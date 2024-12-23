package com.example.demo.config;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.airport.forms.UserForm;
import com.example.airport.forms.UserRegisterForm;
import com.example.airport.forms.admin.FlightForm;
import com.example.airport.viewModel.UserTicketMoreViewModel;
import com.example.airport.viewModel.UserTicketViewModel;
import com.example.airport.viewModel.admin.flight.FlightViewModel;
import com.example.airport.viewModel.admin.ticket.TicketViewModel;
import com.example.airport.viewModel.admin.user.UserViewModel;
import com.example.demo.domain.Flight;
import com.example.demo.domain.Ticket;
import com.example.demo.dto.flight.FlightCreateDto;
import com.example.demo.dto.flight.FlightDto;
import com.example.demo.dto.flight.FlightUpdateDto;
import com.example.demo.dto.ticket.TicketDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.dto.user.UserRegistrationDto;
import com.example.demo.dto.user.UserUpdateDto;

@Configuration
public class ModelMapperConfig {
  @Bean
  public ModelMapper modelMapper() {
    var mapper = new ModelMapper();

    configureModelMapper(mapper);

    return mapper;
  }

  private void configureModelMapper(ModelMapper modelMapper) {
    modelMapper.getConfiguration().setAmbiguityIgnored(true);
    Converter<String, LocalDateTime> stringToLocalDateTimeForFlightConverter = new Converter<>() {

      @Override
      public LocalDateTime convert(MappingContext<String, LocalDateTime> context) {
        return LocalDateTime.parse(context.getSource());
      }
    };
    modelMapper.addConverter(stringToLocalDateTimeForFlightConverter);


    Converter<LocalDateTime, String> localDateTimeToStringForFlightConverter = new Converter<>() {

      @Override
      public String convert(MappingContext<LocalDateTime, String> context) {

        LocalDateTime dateTime = context.getSource();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return dateTime.format(formatter);
      }
    };
    modelMapper.addConverter(localDateTimeToStringForFlightConverter);



    modelMapper
      .createTypeMap(FlightForm.class, FlightCreateDto.class)
      .addMappings(mapper -> {
        mapper.using(stringToLocalDateTimeForFlightConverter).map(flight -> flight.getDeparture(), FlightCreateDto :: setStartDate);
        mapper.using(stringToLocalDateTimeForFlightConverter).map(flight -> flight.getArrival(), FlightCreateDto :: setEndDate);
      });

    modelMapper
      .createTypeMap(Flight.class, FlightDto.class)
      .addMappings(mapper -> {
        mapper.map(flight -> flight.getId(), FlightDto::setId);
        mapper.map(flight -> flight.getName(), FlightDto::setName);
        mapper.map(flight -> flight.getStartDate(), FlightDto::setStartDate);
        mapper.map(flight -> flight.getEndDate(), FlightDto::setEndDate);
        mapper.map(flight -> flight.getDepartureAirport(), FlightDto::setDepartureAirport);
        mapper.map(flight -> flight.getArrivalAirport(), FlightDto::setArrivalAirport);
        mapper.map(flight -> flight.getAirline(), FlightDto::setAirline);
        mapper.map(flight -> flight.getCountSeats(), FlightDto::setCountSeats);
        mapper.map(flight -> flight.getPrice(), FlightDto::setPrice);
    });

    modelMapper
      .createTypeMap(Flight.class, FlightViewModel.class)
      .addMappings(mapper -> {
        mapper.map(flight -> flight.getId(), FlightViewModel::setId);
        mapper.map(flight -> flight.getName(), FlightViewModel::setName);
        mapper.map(flight -> flight.getStartDate(), FlightViewModel::setDeparture);
        mapper.map(flight -> flight.getEndDate(), FlightViewModel::setArrival);
        mapper.map(flight -> flight.getDepartureAirport().getId(), FlightViewModel::setDepartureAirportId);
        mapper.map(flight -> flight.getArrivalAirport().getId(), FlightViewModel::setArrivalAirportId);
        mapper.map(flight -> flight.getAirline().getId(), FlightViewModel::setAirlineId);
        mapper.map(flight -> flight.getCountSeats(), FlightViewModel::setCountSeats);
        mapper.map(flight -> flight.getPrice(), FlightViewModel::setPrice);
    });

    modelMapper
      .createTypeMap(FlightDto.class, FlightForm.class)
      .addMappings(mapper -> {
        mapper.map(flight -> flight.getId(), FlightForm::setId);
        mapper.map(flight -> flight.getName(), FlightForm::setName);
        mapper.using(localDateTimeToStringForFlightConverter).map(flight -> flight.getStartDate(), FlightForm::setDeparture);
        mapper.using(localDateTimeToStringForFlightConverter).map(flight -> flight.getEndDate(), FlightForm::setArrival);
        mapper.map(flight -> flight.getDepartureAirport().getId(), FlightForm::setDepartureAirportId);
        mapper.map(flight -> flight.getArrivalAirport().getId(), FlightForm::setArrivalAirportId);
        mapper.map(flight -> flight.getAirline().getId(), FlightForm::setAirlineId);
        mapper.map(flight -> flight.getCountSeats(), FlightForm::setCountSeats);
        mapper.map(flight -> flight.getPrice(), FlightForm::setPrice);
    });

    modelMapper
    .createTypeMap(FlightForm.class, FlightUpdateDto.class)
    .addMappings(mapper -> {
      mapper.using(stringToLocalDateTimeForFlightConverter).map(form -> form.getDeparture(), FlightUpdateDto::setStartDate);
      mapper.using(stringToLocalDateTimeForFlightConverter).map(form -> form.getArrival(), FlightUpdateDto::setEndDate);
  });

    modelMapper
      .createTypeMap(FlightDto.class, FlightViewModel.class)
      .addMappings(mapper -> {
        mapper.map(flight -> flight.getId(), FlightViewModel::setId);
        mapper.map(flight -> flight.getName(), FlightViewModel::setName);
        mapper.map(flight -> flight.getStartDate(), FlightViewModel::setDeparture);
        mapper.map(flight -> flight.getEndDate(), FlightViewModel::setArrival);
        mapper.map(flight -> flight.getDepartureAirport().getId(), FlightViewModel::setDepartureAirportId);
        mapper.map(flight -> flight.getDepartureAirport().getName(), FlightViewModel::setDepartureAirportName);
        mapper.map(flight -> flight.getDepartureAirport().getCity(), FlightViewModel::setDepartureAirportCity);
        mapper.map(flight -> flight.getArrivalAirport().getId(), FlightViewModel::setArrivalAirportId);
        mapper.map(flight -> flight.getArrivalAirport().getName(), FlightViewModel::setArrivalAirportName);
        mapper.map(flight -> flight.getArrivalAirport().getCity(), FlightViewModel::setArrivalAirportCity);
        mapper.map(flight -> flight.getAirline().getId(), FlightViewModel::setAirlineId);
        mapper.map(flight -> flight.getAirline().getName(), FlightViewModel::setAirlineName);
        mapper.map(flight -> flight.getCountSeats(), FlightViewModel::setCountSeats);
        mapper.map(flight -> flight.getPrice(), FlightViewModel::setPrice);
    });

    modelMapper
    .createTypeMap(Ticket.class, TicketDto.class)
    .addMappings(mapper -> {
      mapper.map(ticket -> ticket.getId(), TicketDto::setId);
      mapper.map(ticket -> ticket.getUser(), TicketDto::setPassenger);
      mapper.map(ticket -> ticket.getFlight(), TicketDto::setFlight);
      mapper.map(ticket -> ticket.getDiscount(), TicketDto::setDiscount);
      mapper.map(ticket -> ticket.getInitialPrice(), TicketDto::setInitialPrice);
      mapper.map(ticket -> ticket.getTicketStatus(), TicketDto::setTicketStatus);
    });

    modelMapper
    .createTypeMap(TicketDto.class, TicketViewModel.class)
    .addMappings(mapper -> {
      mapper.map(ticket -> ticket.getId(), TicketViewModel::setId);
      mapper.map(ticket -> ticket.getPassenger().getId(), TicketViewModel::setUserId);
      mapper.map(ticket -> ticket.getPassenger().getSurname(), TicketViewModel::setUserSurname);
      mapper.map(ticket -> ticket.getPassenger().getName(), TicketViewModel::setUserName);
      mapper.map(ticket -> ticket.getPassenger().getLastName(), TicketViewModel::setUserLastname);
      mapper.map(ticket -> ticket.getFlight().getId(), TicketViewModel::setFlightId);
      mapper.map(ticket -> ticket.getFlight().getName(), TicketViewModel::setFlightName);
      mapper.map(ticket -> ticket.getDiscount(), TicketViewModel::setDiscount);
      mapper.map(ticket -> ticket.getInitialPrice(), TicketViewModel::setInitialPrice);
      mapper.map(ticket -> ticket.getTicketStatus(), TicketViewModel::setTicketStatus);
    });

    modelMapper
    .createTypeMap(TicketDto.class, UserTicketViewModel.class)
    .addMappings(mapper -> {
      mapper.map(dto -> dto.getId(), UserTicketViewModel::setTicketId);
      mapper.map(dto -> dto.getFlight().getName(), UserTicketViewModel::setNameFlight);
      mapper.map(dto -> dto.getFlight().getStartDate(), UserTicketViewModel::setDepartureDate);
      mapper.map(dto -> dto.getFlight().getEndDate(), UserTicketViewModel::setArrivalDate);
      mapper.map(dto -> dto.getTotalPrice(), UserTicketViewModel::setTotalPrice);
    });

    modelMapper
    .createTypeMap(TicketDto.class, UserTicketMoreViewModel.class)
    .addMappings( mapper -> {
      mapper.map(dto -> dto.getId(), UserTicketMoreViewModel :: setTicketId);
      mapper.map(dto -> dto.getFlight().getName(), UserTicketMoreViewModel :: setFlightName);
      mapper.map(dto -> dto.getFlight().getStartDate(), UserTicketMoreViewModel :: setDepartureDate);
      mapper.map(dto -> dto.getFlight().getEndDate(), UserTicketMoreViewModel :: setArrivalDate);
      mapper.map(dto -> dto.getFlight().getDepartureAirport().getName(), UserTicketMoreViewModel :: setDepartureAirportName);
      mapper.map(dto -> dto.getFlight().getDepartureAirport().getCity(), UserTicketMoreViewModel :: setDepartureAirportCity);
      mapper.map(dto -> dto.getFlight().getArrivalAirport().getName(), UserTicketMoreViewModel :: setArrivalAirportName);
      mapper.map(dto -> dto.getFlight().getArrivalAirport().getCity(), UserTicketMoreViewModel :: setArrivalAirportCity);
      mapper.map(dto -> dto.getFlight().getAirline().getName(), UserTicketMoreViewModel :: setAirlineName);
      mapper.map(dto -> dto.getInitialPrice(), UserTicketMoreViewModel :: setInitialPrice);
      mapper.map(dto -> dto.getDiscount(), UserTicketMoreViewModel :: setDiscount);
      mapper.map(dto -> dto.getTotalPrice(), UserTicketMoreViewModel :: setTotalPrice);
      mapper.map(dto -> dto.getTicketStatus(), UserTicketMoreViewModel :: setStatus);
    });


    Converter<String, LocalDateTime> stringToLocalDateTimeConverter = new Converter<>() {

      @Override
      public LocalDateTime convert(MappingContext<String, LocalDateTime> context) {
        return LocalDateTime.parse(context.getSource() + "T00:00:00.000");
      }
    };

    modelMapper.addConverter(stringToLocalDateTimeConverter);

    modelMapper
    .createTypeMap(UserRegisterForm.class, UserRegistrationDto.class)
    .addMappings( mapper -> {
      mapper.using(stringToLocalDateTimeConverter).map(form -> form.getBirthDate(), UserRegistrationDto::setBirthDate);
      });

    modelMapper
    .createTypeMap(UserForm.class, UserUpdateDto.class)
    .addMappings(mapper -> {
      mapper.using(stringToLocalDateTimeConverter).map(form -> form.getBirthDate(), UserUpdateDto::setBirthDate);
    });

    modelMapper
    .createTypeMap(UserDto.class, UserForm.class)
    .addMappings(mapper -> {
      mapper.using(localDateTimeToStringForFlightConverter).map(dto -> dto.getBirthDate(), UserForm::setBirthDate);
    });

    modelMapper
    .createTypeMap(UserDto.class, UserViewModel.class)
    .addMappings(mapper -> {
      mapper.map(dto -> dto.getBirthDate(), UserViewModel::setBirthDate);
    });


  }

}

