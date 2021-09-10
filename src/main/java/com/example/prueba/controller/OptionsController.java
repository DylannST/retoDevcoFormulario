package com.example.prueba.controller;


import com.example.prueba.entity.Options;
import com.example.prueba.service.OptionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void updateOptions(@RequestBody Options options) {
        optionsService.updateOptions(options);
    }

    @GetMapping("api/media/options")
    public int getMedia(@RequestBody List<Options> options) {
        return optionsService.getMedia(options);
    }

    @GetMapping("api/options/{idQuestion}")
    public List<Object> getOptions(@PathVariable("idQuestion") Long idQuestion) {
        return optionsService.getOptions(idQuestion);
    }
}
