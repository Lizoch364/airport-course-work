package com.example.demo.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.airport.controllers.admin.AdminUserController;
import com.example.airport.forms.UserForm;
import com.example.airport.viewModel.admin.AdminGetAllViewModel;
import com.example.airport.viewModel.admin.AdminGetByIdViewModel;
import com.example.airport.viewModel.admin.user.UserCreateViewModel;
import com.example.airport.viewModel.admin.user.UserUpdateViewModel;
import com.example.airport.viewModel.admin.user.UserViewModel;
import com.example.demo.domain.enums.UserRole;
import com.example.demo.dto.user.UserCreateDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.dto.user.UserUpdateDto;
import com.example.demo.services.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin/users")
public class UserControllerImpl extends BaseController implements AdminUserController{
  private UserService userService;
  private ModelMapper modelMapper;

  @Override
  @GetMapping
  public String findAll(Model model) {
    List<UserViewModel> users = userService.findAll().stream().map(user -> modelMapper.map(user, UserViewModel.class)).toList();

    var getAllUsers = new AdminGetAllViewModel<UserViewModel>(
      createBaseViewModel("Список всех пользователей"),
      users
    );

    model.addAttribute("model", getAllUsers);

    return "pages/admin/user/all-users";
  }

  @Override
  @GetMapping("/{id}")
  public String findById(@PathVariable int id, Model model) {
    UserViewModel user = modelMapper.map(userService.findById(id), UserViewModel.class);

    var getUserById = new AdminGetByIdViewModel<UserViewModel>(
      createBaseViewModel("Пользователь с id " + id),
      user
    );

    model.addAttribute("model", getUserById);

    return "pages/admin/user/find-one-user";
  }

  @Override
  @GetMapping("/create")
  public String createForm(Model model) {
    var createViewModel = new UserCreateViewModel(
      createBaseViewModel("Создание нового пользователя")
    );

    model.addAttribute("model", createViewModel);
    model.addAttribute("form", new UserForm(null, null, null, null, null, null));

    return "pages/admin/user/create-user";
  }

  @Override
  @PostMapping("/create")
  public String create(@Valid UserForm form, BindingResult result, Model model) {
    if (result.hasErrors()) {
      var createViewModel = new UserCreateViewModel(
        createBaseViewModel("Создание пользователя")
      );

      model.addAttribute("model", createViewModel);
      model.addAttribute("form", form);

      return "pages/admin/user/create-user";
    }

    UserDto userDto = userService.create(modelMapper.map(form, UserCreateDto.class));
    return "redirect:/admin/users/" + userDto.getId();
  }

  @Override
  @GetMapping("/update/{id}")
  public String editForm(@PathVariable int id, Model model) {
    UserDto user = userService.findById(id);
    var updateViewModel = new UserUpdateViewModel(
      createBaseViewModel("Обновление пользователя")
    );

    model.addAttribute("model", updateViewModel);
    model.addAttribute("form", modelMapper.map(user, UserForm.class));

    return "pages/admin/user/update-user";
  }

  @Override
  @PostMapping("/update/{id}")
  public String update(@PathVariable int id, UserForm form, BindingResult result, Model model) {
    if (result.hasErrors()) {
      var updateViewModel = new UserUpdateViewModel(
        createBaseViewModel("Обновление пользователя")
      );

      model.addAttribute("model", updateViewModel);
      model.addAttribute("form", form);

      return "pages/admin/user/update-user";
    }

    UserUpdateDto userDto = modelMapper.map(form, UserUpdateDto.class);
    userService.update(userDto);

    return "redirect:/admin/users/" + id;
  }

  @Autowired
  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  @Autowired
  public void setModelMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }
}
