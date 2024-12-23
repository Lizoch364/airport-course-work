package com.example.airport.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/login")
public interface LoginController {
  @GetMapping
  String getSignInPage(
    Model model
  );

  @PostMapping
  String signIn(
    String username,
    RedirectAttributes redirectAttributes,
    Model model
  );
}
