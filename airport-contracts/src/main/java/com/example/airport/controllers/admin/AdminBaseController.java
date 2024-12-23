package com.example.airport.controllers.admin;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface AdminBaseController {
  @GetMapping
  String findAll(Model model);

  @GetMapping("/{id}")
  String findById(
    @PathVariable("id") int id,
    Model model
  );
}
