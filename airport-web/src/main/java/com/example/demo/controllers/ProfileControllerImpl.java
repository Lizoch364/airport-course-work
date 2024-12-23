package com.example.demo.controllers;

import java.security.Principal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.airport.controllers.ProfileController;
import com.example.airport.forms.UserForm;
import com.example.airport.forms.UpdatePasswordForm;

import com.example.airport.viewModel.admin.user.UserCreateViewModel;
import com.example.airport.viewModel.admin.user.UserUpdateViewModel;
import com.example.airport.viewModel.admin.user.UserViewModel;
import com.example.demo.dto.user.UserUpdateDto;
import com.example.demo.dto.user.UserUpdatePasswordDto;
import com.example.demo.services.UserAuthService;
import com.example.demo.services.UserService;

@Controller
@RequestMapping("/profile")
public class ProfileControllerImpl extends BaseController implements ProfileController{
  private UserService userService;
  private UserAuthService userAuthService;

  private ModelMapper modelMapper;

  @Override
  @GetMapping
  public String getPersonalAccountPage(Principal principal, Model model) {
    UserViewModel user = modelMapper.map(userService.findByLogin(principal.getName()), UserViewModel.class);
    user.setBirthDate(user.getBirthDate().substring(0, 10));
    var viewModel = new UserCreateViewModel(
      createBaseViewModel("Личный кабинет")
    );
    model.addAttribute("model", viewModel);
    model.addAttribute("user", user);

    return "pages/auth/profile";
  }

  @Override
  @GetMapping("/update")
  public String getUpdatePersonalAccountPage(Principal principal, Model model) {
    UserForm user = modelMapper.map(userService.findByLogin(principal.getName()), UserForm.class);
    user.setBirthDate(user.getBirthDate().substring(0, 10));

    var viewModel = new UserUpdateViewModel(
      createBaseViewModel( "редактирование пользователя")
    );

    model.addAttribute("model", viewModel);
    model.addAttribute("form", user);

    return "pages/auth/update-profile";
  }

  @Override
  @PostMapping("/update")
  public String updatePersonalAccount(Principal principal, UserForm form, BindingResult result,  Model model) {
    if (result.hasErrors()) {
      var viewModel = new UserUpdateViewModel(
        createBaseViewModel("редактирование пользователя")
      );

      model.addAttribute("model", viewModel);
      model.addAttribute("form", form);

      return "pages/auth/update-profile";
    }

    UserUpdateDto user = modelMapper.map(form, UserUpdateDto.class);
    userService.update(user);

    return "redirect:/profile";
  }

  @Override
  @GetMapping("/update-password")
  public String getUpdatePasswordPersonalAccountPage(Principal principal, Model model) {
    var form = new UpdatePasswordForm(null, null);

    var viewModel = new UserUpdateViewModel(
      createBaseViewModel( "редактирование пароля")
    );

    model.addAttribute("model", viewModel);
    model.addAttribute("form", form);

    return "pages/auth/update-password";
  }

  @Override
  @PostMapping("/update-password")
  public String updatePasswordPersonalAccount(Principal principal, UpdatePasswordForm form, BindingResult result,  Model model) {
    if (result.hasErrors()) {
      var viewModel = new UserUpdateViewModel(
        createBaseViewModel("редактирование пароля")
      );

      model.addAttribute("model", viewModel);
      model.addAttribute("form", form);

      return "pages/auth/update-password";
    }

    var user = userService.findByLogin(principal.getName());

    UserUpdatePasswordDto dto = new UserUpdatePasswordDto(user.getId(), form.getNewPassword(), form.getConfirmPassword());
    userAuthService.updatePassword(dto);

    return "redirect:/profile";
  }

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
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
