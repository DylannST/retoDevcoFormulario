package com.example.prueba.service;


import com.example.prueba.entity.Options;
import com.example.prueba.interfaces.OptionsServiceInterface;
import com.example.prueba.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionsService implements OptionsServiceInterface {


    @Autowired
    OptionRepository optionRepository;

    public List<Options> saveOptions(List<Options> options) {
        return (List<Options>) optionRepository.saveAll(options);
    }

    public void updateOptions(Options options) {
        optionRepository.updateOptions(
                options.getDescription(),
                options.isSuccess(),
                options.getIdOption(),
                options.getQuestion().getIdQuestion()
        );
    }
}
