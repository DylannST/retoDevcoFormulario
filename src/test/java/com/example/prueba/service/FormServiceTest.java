package com.example.prueba.service;

import com.example.prueba.entity.Form;
import com.example.prueba.repository.FormRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class FormServiceTest {

    @Mock
    FormRepository formRepository;

    @InjectMocks
    FormService formService;

    Form form = new Form(1L, "Desarrollador");

    @Test
    void saveForm() {


        when(formRepository.save(form)).thenReturn(form);

        assertEquals("Desarrollador", formService.saveForm(form).getDescription());
    }
}