package com.example.demo.controllers;

import com.example.airport.controllers.admin.AdminAirlineController;
import com.example.airport.forms.admin.AirlineForm;
import com.example.airport.viewModel.admin.AdminGetAllViewModel;
import com.example.airport.viewModel.admin.AdminGetByIdViewModel;
import com.example.airport.viewModel.admin.airline.AirlineUpdateViewModel;
import com.example.airport.viewModel.admin.airline.AirlineViewModel;
import com.example.airport.viewModel.admin.airline.AirlineCreateViewModel;
import com.example.demo.dto.airline.AirlineCreateDto;
import com.example.demo.dto.airline.AirlineDto;
import com.example.demo.dto.airline.AirlineUpdateDto;
import com.example.demo.services.AirlineService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.modelmapper.ModelMapper;

@Controller
@RequestMapping("/admin/airlines")
public class AirlineControllerImpl extends BaseController implements AdminAirlineController {

    private AirlineService airlineService;
    private ModelMapper modelMapper;


    @Override
    @GetMapping("")
    public String findAll(Model model) {
        List<AirlineViewModel> airlines = airlineService.findAll().stream().map(
               airline -> modelMapper.map(airline, AirlineViewModel.class)
        ).toList();

        var getAllAirlinesViewModel = new AdminGetAllViewModel<AirlineViewModel>(
                createBaseViewModel("Список авиакомпаний"),
                airlines
        );

        model.addAttribute("model", getAllAirlinesViewModel);

        return "pages/admin/airline/all-airlines";
    }

    @Override
    @GetMapping("/{id}")
    public String findById(@PathVariable int id, Model model) {
        AirlineViewModel airlineViewModel = modelMapper.map(airlineService.findById(id), AirlineViewModel.class);

        var getAirlineByIdViewModel = new AdminGetByIdViewModel<AirlineViewModel>(
            createBaseViewModel("Авиакомпания " + airlineViewModel.getName()),
            airlineViewModel
        );

        model.addAttribute("model", getAirlineByIdViewModel);

        return "pages/admin/airline/find-one-airline";
    }

    @Override
    @GetMapping("/create")
    public String createForm(Model model) {
        var airlineCreateViewModel = new AirlineCreateViewModel(
            createBaseViewModel("Создание авиакомпании")
        );

        model.addAttribute("model", airlineCreateViewModel);
        model.addAttribute("form", new AirlineForm(""));

        return "pages/admin/airline/create-airline";
    }

    @Override
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("form") AirlineForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            var airlineCreateViewModel = new AirlineCreateViewModel(
                createBaseViewModel("Создание авиакомпании")
            );

            model.addAttribute("model", airlineCreateViewModel);
            model.addAttribute("form", form);

            return "pages/admin/airline/create-airline";
        }

        AirlineCreateDto airline = modelMapper.map(form, AirlineCreateDto.class);
        AirlineDto airlineDto = airlineService.create(airline);

        return "redirect:/admin/airlines/" + airlineDto.getId();
    }

    @Override
    @GetMapping("/update/{id}")
    public String editForm(@PathVariable int id, Model model) {
        AirlineForm airlineForm = modelMapper.map(airlineService.findById(id), AirlineForm.class);

        var updateViewModel = new AirlineUpdateViewModel(
            createBaseViewModel("Обновление авиакомпании")
        );

        model.addAttribute("model", updateViewModel);
        model.addAttribute("form", airlineForm);

        return "pages/admin/airline/update-airline";
    }

    @Override
    @PostMapping("/update/{id}")
    public String update(@PathVariable int id, @Valid @ModelAttribute("form") AirlineForm updateForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            var airlineUpdateViewModel = new AirlineUpdateViewModel(
                createBaseViewModel( "Обновление авиакомпании")
            );

            model.addAttribute("model", airlineUpdateViewModel);
            model.addAttribute("form", updateForm);

            return "pages/admin/airline/update-airline";
        }

        AirlineUpdateDto airlineDto = modelMapper.map(updateForm, AirlineUpdateDto.class);
        airlineService.update(airlineDto);

        return "redirect:/admin/airlines/" + airlineDto.getId();
    }


    @Autowired
    public void setAirlineService(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
}
