package com.example.prueba.service;

import com.example.prueba.entity.Form;
import com.example.prueba.interfaces.FormServiceInterface;
import com.example.prueba.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService implements FormServiceInterface {

    @Autowired
    FormRepository formRepository;

    public Form saveForm(Form form) {
        return formRepository.save(form);
    }

}
