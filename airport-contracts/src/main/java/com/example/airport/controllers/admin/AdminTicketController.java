package com.example.airport.controllers.admin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/tickets")
public interface AdminTicketController extends AdminBaseController{
    @PostMapping("decline/{id}")
    String decline(@PathVariable int id);
}
