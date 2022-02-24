package com.pdv.controller;

import com.pdv.service.ComponenteService;
import com.pdv.model.Componente;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/componente")
public class ComponenteController {

    @Autowired
    private ComponenteService componenteService;

    @PostMapping
    public Componente save(@RequestBody @Valid Componente componente) {
        return componenteService.save(componente);
    }
}
