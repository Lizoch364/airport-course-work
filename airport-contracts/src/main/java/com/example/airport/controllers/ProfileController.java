package com.example.airport.controllers;

import java.security.Principal;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.airport.forms.UpdatePasswordForm;
import com.example.airport.forms.UserForm;


@RequestMapping("/profile")
public interface ProfileController {
  @GetMapping()
  String getPersonalAccountPage(
    Principal principal,
    Model model
  );

  @GetMapping("/update")
  String getUpdatePersonalAccountPage(
    Principal principal,
    Model model
  );

  @PostMapping("/update")
  String updatePersonalAccount(
    Principal principal,
    @ModelAttribute("form") UserForm form,
    BindingResult result,
    Model model);

  @GetMapping("/update-password")
  public String getUpdatePasswordPersonalAccountPage(
    Principal principal,
    Model model);


  @PostMapping("/update-password")
  public String updatePasswordPersonalAccount(
    Principal principal,
    UpdatePasswordForm form,
    BindingResult result,
    Model model);

}
