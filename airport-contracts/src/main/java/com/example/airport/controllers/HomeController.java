package com.example.airport.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public interface HomeController {
  @GetMapping("/admin")
  public String getHomeAdminPage(
    Model model
  );
}
