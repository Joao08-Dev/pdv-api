package com.pdv.controller;

import com.pdv.model.Ingrediente;
import com.pdv.service.IngredienteService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {
     
    @Autowired
    private IngredienteService ingredienteService;
  
    @PostMapping
    public Ingrediente save(@RequestBody @Valid Ingrediente ingrediente) {
        return ingredienteService.save(ingrediente);
    }

    @GetMapping
    public List<Ingrediente> todos() {
        return ingredienteService.todos();
    }
}
