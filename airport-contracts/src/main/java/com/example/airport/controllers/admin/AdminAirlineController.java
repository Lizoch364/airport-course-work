package com.example.airport.controllers.admin;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.airport.forms.admin.AirlineForm;

@RequestMapping("/admin/airlines")
public interface AdminAirlineController extends AdminBaseController {
    @PostMapping("/create")
    String create(
        @ModelAttribute("form")
        AirlineForm form,
        BindingResult result,
        Model model
    );

    @PostMapping("update/{id}")
    String update(
        @PathVariable("id")
        int id,
        @ModelAttribute("form")
        AirlineForm form,
        BindingResult result,
        Model model
    );

    @GetMapping("/create")
    String createForm(Model model);

    @GetMapping("/{id}/edit")
    String editForm(
        @PathVariable("id") int id,
        Model model
    );
}
