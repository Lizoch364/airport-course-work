package com.example.demo.controllers;

import com.example.airport.viewModel.BaseViewModel;

public class BaseController {
  public BaseViewModel createBaseViewModel(String title) {
    return new BaseViewModel(title);
  }
}
