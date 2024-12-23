package com.example.demo.controllers;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.airport.controllers.LoginController;
import com.example.airport.viewModel.HomeViewModel;

@Controller
@RequestMapping("/login")
public class LoginControllerImpl extends BaseController implements LoginController{

  @Override
  @GetMapping
  public String getSignInPage(Model model) {
    model.addAttribute("model", new HomeViewModel(createBaseViewModel("Авторизация")));

    return "pages/auth/log-in";
  }

  @Override
  @PostMapping("/error")
  public String signIn(@ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String login,
    RedirectAttributes redirectAttributes,  Model model) {

    model.addAttribute("model", new HomeViewModel(createBaseViewModel("Авторизация")));

    redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, login);
    redirectAttributes.addFlashAttribute("badCredentials", true);

    return "redirect:/login";
  }
}
