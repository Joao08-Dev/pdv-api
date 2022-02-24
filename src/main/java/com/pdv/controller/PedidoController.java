package com.pdv.controller;

import com.pdv.service.PedidoServico;
import com.pdv.model.Pedido;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoServico pedidoServico;

    @PostMapping
    public Pedido novo(@RequestBody @Valid Pedido pedido) {
        return pedidoServico.novo(pedido);
    }
}
