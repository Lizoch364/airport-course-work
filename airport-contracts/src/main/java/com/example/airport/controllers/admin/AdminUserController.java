package com.example.airport.controllers.admin;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.airport.forms.UserForm;

public interface AdminUserController extends AdminBaseController{
    @PostMapping("/create")
    String create(
        @ModelAttribute("form")
        UserForm form,
        BindingResult result,
        Model model
    );

    @PatchMapping("update/{id}")
    String update(
        @PathVariable("id")
        int id,
        @ModelAttribute("form")
        UserForm form,
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
