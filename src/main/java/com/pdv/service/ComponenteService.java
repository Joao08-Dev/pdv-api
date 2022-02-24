package com.pdv.service;

import com.pdv.model.Componente;
import com.pdv.repository.ComponenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComponenteService {

    @Autowired
    private ComponenteRepository componenteRepository;

    public Componente save(Componente componente) {
        return componenteRepository.save(componente);
    }

}
