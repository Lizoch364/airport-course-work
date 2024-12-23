package com.example.airport.controllers.admin;

import com.example.airport.forms.admin.AirportForm;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/admin/airports")
public interface AdminAirportController extends AdminBaseController {
    @PostMapping("/create")
    String create(
        @ModelAttribute("form")
        AirportForm form,
        BindingResult result,
        Model model
    );

    @PatchMapping("update/{id}")
    String update(
        @PathVariable("id")
        int id,
        @ModelAttribute("form")
        AirportForm form,
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
