package com.example.demo.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.airport.controllers.RegistrationController;
import com.example.airport.forms.UserRegisterForm;
import com.example.airport.viewModel.RegistrationViewModel;
import com.example.demo.dto.user.UserRegistrationDto;
import com.example.demo.services.UserAuthService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterControllerImpl extends BaseController implements RegistrationController {
    private UserAuthService userAuthService;

    private ModelMapper modelMapper;

    @Override
    @GetMapping
    public String getRegistrationPage(Model model) {
        var viewModel = new RegistrationViewModel(
            createBaseViewModel("Регистрация")
        );

        model.addAttribute("model", viewModel);
        model.addAttribute("form", new UserRegisterForm(null, null, null, null, null, null, null));
        return "pages/auth/register";
    }

    @Override
    @PostMapping
    public String register(@Valid UserRegisterForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            var viewModel = new RegistrationViewModel(
                createBaseViewModel("Регистрация")
            );

            model.addAttribute("model", viewModel);
            model.addAttribute("form", form);
            return "pages/auth/register";
        }

        userAuthService.register(modelMapper.map(form, UserRegistrationDto.class));
        System.out.println("redirect to ...");
        return "redirect:/login";
    }

    @Autowired
    public void setUserAuthService(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
