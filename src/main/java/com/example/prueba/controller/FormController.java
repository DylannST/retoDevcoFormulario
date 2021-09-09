package com.example.prueba.controller;


import com.example.prueba.entity.Form;
import com.example.prueba.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormController {

    @Autowired
    FormService formService;

    @PostMapping("api/form")
    public Form saveForm(@RequestBody Form form) {
        return formService.saveForm(form);
    }


}
