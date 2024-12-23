package com.example.demo.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.airport.controllers.admin.AdminTicketController;
import com.example.airport.viewModel.admin.AdminGetAllViewModel;
import com.example.airport.viewModel.admin.AdminGetByIdViewModel;
import com.example.airport.viewModel.admin.ticket.TicketViewModel;
import com.example.demo.services.TicketService;

@Controller
@RequestMapping("/admin/tickets")
public class TicketControllerImpl extends BaseController implements AdminTicketController{
  private TicketService ticketService;
  private ModelMapper modelMapper;
  @Override
  @GetMapping
  public String findAll(Model model) {
    List<TicketViewModel> tickets = ticketService.findAll()
      .stream()
      .map(ticket -> modelMapper.map(ticket, TicketViewModel.class))
      .toList();

    var getAllTicketsViewModel = new AdminGetAllViewModel<TicketViewModel>(
      createBaseViewModel("Билеты"),
      tickets
    );

    model.addAttribute("model", getAllTicketsViewModel);

  return "pages/admin/ticket/all-tickets";
  }

  @Override
  @GetMapping("/{id}")
  public String findById(@PathVariable int id, Model model){
    TicketViewModel ticket = modelMapper.map(ticketService.findById(id), TicketViewModel.class);

    var getTicketById = new AdminGetByIdViewModel<>(
      createBaseViewModel("Билет с id = " + id),
      ticket
    );

    model.addAttribute("model", getTicketById);
    return "pages/admin/ticket/find-one-ticket";
  }

  @Override
  @PostMapping("/decline/{id}")
  public String decline(@PathVariable int id) {
    ticketService.decline(id);

    return "redirect:/admin/tickets";
  }

  @Autowired
  public void setTicketService(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  @Autowired
  public void setModelMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }
}
