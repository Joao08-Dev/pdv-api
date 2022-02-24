package com.pdv.service;

import com.pdv.model.Ingrediente;
import com.pdv.repository.IngredienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService{

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public Ingrediente save(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }
    
    public List<Ingrediente> todos(){
        return ingredienteRepository.findAll();
    }
}
