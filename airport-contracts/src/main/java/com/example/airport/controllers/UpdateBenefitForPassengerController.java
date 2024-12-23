package com.example.airport.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.airport.forms.UpdateBenefitForm;

@RequestMapping("/update-benefit")
public interface UpdateBenefitForPassengerController {
  @GetMapping
  String getBenefitForPassengerPage(
    Model model
  );

  @PatchMapping()
  String updateBenefitForPassenger(
    @ModelAttribute("form") UpdateBenefitForm form,
    Model model
  );
}
