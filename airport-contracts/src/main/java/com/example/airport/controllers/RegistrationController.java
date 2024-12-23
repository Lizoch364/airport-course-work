package com.example.airport.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.airport.forms.UserRegisterForm;

@RequestMapping("/register")
public interface RegistrationController {
  @GetMapping
  String getRegistrationPage(
    Model model
  );

  @PostMapping
  String register(
    @ModelAttribute("form") UserRegisterForm form,
    BindingResult bindingResult,
    Model model
  );
}
