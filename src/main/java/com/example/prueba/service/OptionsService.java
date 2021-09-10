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

    public int getMedia(List<Options> options) {
        Options optionsOri;
        int valorTotal = 0;
        for (Options option : options) {
            optionsOri = optionRepository.findById(option.getIdOption()).get();
            if (optionsOri.isSuccess()) {
                valorTotal += 4;
            } else {
                valorTotal += -1;
            }
        }


        return (valorTotal / options.size());
    }

    public List<Object> getOptions(Long idQuestion) {
        return optionRepository.getOptions(idQuestion);
    }

    public List<Options> getRightandWrongOptions(List<Options> options) {

        options.forEach(x -> {
            Options option = optionRepository.findById(x.getIdOption()).get();
            x.setSuccess(option.isSuccess());
        });
        return options;
    }
}
