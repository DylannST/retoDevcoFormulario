package com.example.prueba.interfaces;

import com.example.prueba.entity.Options;

import java.util.List;

public interface OptionsServiceInterface {

    List<Options> saveOptions(List<Options> options);

    void updateOptions(Options options);

}
