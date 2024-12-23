package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.airport.controllers.HomeController;
import com.example.airport.viewModel.HomeViewModel;

@Controller
public class HomeControllerImpl  extends BaseController implements HomeController {

  @Override
  public String getHomeAdminPage(Model model) {
    var viewModel = new HomeViewModel(
      createBaseViewModel("Домашняя страница администратора")
    );
    model.addAttribute("model", viewModel);

    return "pages/admin/home-admin";
  }
}
