package com.example.prueba.controller;


import com.example.prueba.entity.Options;
import com.example.prueba.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OptionsController {

    @Autowired
    OptionsService optionsService;

    @PostMapping("api/options")
    public List<Options> saveOptions(@RequestBody List<Options> options) {
        return optionsService.saveOptions(options);
    }

    @PutMapping("api/options")
    public void updateOptions(@RequestBody Options options){
        optionsService.updateOptions(options);
    }
}
