package com.example.demo.controllers;

import com.example.airport.controllers.admin.AdminAirportController;
import com.example.airport.forms.admin.AirportForm;
import com.example.airport.viewModel.admin.AdminGetAllViewModel;
import com.example.airport.viewModel.admin.AdminGetByIdViewModel;
import com.example.airport.viewModel.admin.airport.AirportCreateViewModel;
import com.example.airport.viewModel.admin.airport.AirportUpdateViewModel;
import com.example.airport.viewModel.admin.airport.AirportViewModel;
import com.example.demo.dto.airport.AirportDto;
import com.example.demo.services.AirportService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;

import com.example.demo.dto.airport.AirportCreateDto;
import com.example.demo.dto.airport.AirportUpdateDto;

@Controller
@RequestMapping("/admin/airports")
public class AirportControllerImpl extends BaseController implements AdminAirportController {
    private AirportService airportService;
    private ModelMapper modelMapper;
    @Override
    @GetMapping("")
    public String findAll(Model model) {
        List<AirportViewModel> airportsViewModel = airportService.findAll().stream().map(airport -> modelMapper.map(airport, AirportViewModel.class)).toList();

        var allAirportViewModel = new AdminGetAllViewModel<AirportViewModel>(
            createBaseViewModel("Список всех аэропортов"),
            airportsViewModel
        );

        model.addAttribute("model", allAirportViewModel);

        return "pages/admin/airport/all-airports";
    }

    @Override
    @GetMapping("/{id}")
    public String findById(@PathVariable int id, Model model) {
        var airportViewModel = modelMapper.map(airportService.findById(id), AirportViewModel.class);

        var airportById = new AdminGetByIdViewModel<AirportViewModel>(
            createBaseViewModel("Аэропорт " + airportViewModel.getName()),
            airportViewModel
        );

        model.addAttribute("model", airportById);

        return "pages/admin/airport/find-one-airport";
    }

    @Override
    @GetMapping("/create")
    public String createForm(Model model) {
        var createAirportViewModel = new AirportCreateViewModel(
            createBaseViewModel("Создание аэропорта")
        );

        model.addAttribute("model", createAirportViewModel);
        model.addAttribute("form", new AirportForm("", ""));

        return "pages/admin/airport/create-airport";
    }

    @Override
    @PostMapping("/create")
    public String create(@Valid AirportForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            var createAirportViewModel = new AirportCreateViewModel(
                createBaseViewModel("Создание аэропорта")
            );

            model.addAttribute("model", createAirportViewModel);
            model.addAttribute("form", form);

            return "pages/admin/airport/create-airport";
        }

        AirportDto airportDto = airportService.create(modelMapper.map(form, AirportCreateDto.class));
        return "redirect:/admin/airports/" + airportDto.getId();
    }

    @Override
    @GetMapping("/update/{id}")
    public String editForm(@PathVariable int id, Model model) {
        AirportForm airportForm = modelMapper.map(airportService.findById(id), AirportForm.class);

        var updateViewModel = new AirportUpdateViewModel(
            createBaseViewModel("Обновление аэропорта")
        );

        model.addAttribute("model", updateViewModel);
        model.addAttribute("form", airportForm);
        return "pages/admin/airport/update-airport";
    }

    @Override
    @PostMapping("/update/{id}")
    public String update(@PathVariable int id, @Valid AirportForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            var updateViewModel = new AirportUpdateViewModel(
            createBaseViewModel("Обновление аэропорта")
            );

            model.addAttribute("model", updateViewModel);
            model.addAttribute("form", form);

            return "pages/admin/airport/update-airport";
        }

        airportService.update(modelMapper.map(form, AirportUpdateDto.class));
        return "redirect:/admin/airports/" + id;
    }

    @Autowired
    public void setAirportService(AirportService airportService) {
        this.airportService = airportService;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
