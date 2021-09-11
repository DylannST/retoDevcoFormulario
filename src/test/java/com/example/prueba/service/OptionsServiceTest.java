package com.example.prueba.service;

import com.example.prueba.entity.Options;
import com.example.prueba.entity.Question;
import com.example.prueba.repository.OptionRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class OptionsServiceTest {

    @Mock
    OptionRepository optionRepository;

    @InjectMocks
    OptionsService optionsService;


    @Test
    void saveOptions() {
        Options opcion1 = new Options(1L, "Madrid", true, new Question(2L, "", null));
        Options opcion2 = new Options(2L, "Bogota", false, new Question(3L, "", null));
        Options opcion3 = new Options(3L, "Grecia", true, new Question(4L, "", null));
        List<Options> options = new ArrayList<>();
        options.add(opcion1);
        options.add(opcion2);
        options.add(opcion3);

        when(optionRepository.saveAll(options)).thenReturn(options);


        assertEquals(opcion3, optionsService.saveOptions(options).get(2));

    }

    @Test
    void updateOptions() {
        Options opcion1 = new Options(1L, "Madrid", true, new Question(2L, "", null));

        ArgumentCaptor valueCapture = ArgumentCaptor.forClass(String.class);
        doNothing()
                .when(optionRepository)
                .updateOptions((String) valueCapture.capture(), isA(Boolean.class), isA(Long.class), isA(Long.class));

        optionsService.updateOptions(opcion1);
        assertEquals("Madrid", valueCapture.getValue());
    }

    @Test
    void getMedia() {
        int mediaTotal = 0;
        Options opcion1 = new Options(1L, "Madrid", true, new Question(2L, "", null));
        Options opcion2 = new Options(2L, "Bogota", true, new Question(3L, "", null));
        Options opcion3 = new Options(3L, "Grecia", true, new Question(4L, "", null));
        List<Options> options = new ArrayList<>();
        options.add(opcion1);
        options.add(opcion2);
        options.add(opcion3);

        for (Options option : options) {
            when(optionRepository.findById(option.getIdOption())).thenReturn(Optional.of(option));
        }
        mediaTotal = optionsService.getMedia(options);

        assertEquals(4, mediaTotal);

    }

    @Test
    void getOptions() {

        Options opcion1 = new Options(1L, "Madrid", true, new Question(2L, "", null));
        Options opcion2 = new Options(2L, "Bogota", true, new Question(3L, "", null));
        Options opcion3 = new Options(3L, "Grecia", true, new Question(4L, "", null));

        List<Object> options = new ArrayList<>();
        options.add(opcion1);
        options.add(opcion2);
        options.add(opcion3);

        when(optionRepository.getOptions(1l)).thenReturn(options);

        assertEquals(opcion1, optionsService.getOptions(1L).get(0));
        assertEquals(opcion2, optionsService.getOptions(1L).get(1));
        assertEquals(opcion3, optionsService.getOptions(1L).get(2));

    }

    @Test
    void getRightandWrongOptions() {
        Options opcion1 = new Options(1L, "Madrid", true, new Question(2L, "", null));
        Options opcion2 = new Options(2L, "Bogota", true, new Question(3L, "", null));
        Options opcion3 = new Options(3L, "Grecia", true, new Question(4L, "", null));
        List<Options> options = new ArrayList<>();
        options.add(opcion1);
        options.add(opcion2);
        options.add(opcion3);


        for (Options option : options) {
            when(optionRepository.findById(option.getIdOption())).thenReturn(Optional.of(option));
        }



    assertTrue(optionsService.getRightandWrongOptions(options).get(0).isSuccess());

    }
}