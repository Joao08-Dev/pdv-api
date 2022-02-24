package com.pdv.controller;

import com.pdv.service.ItemPedidoService;
import com.pdv.model.ItemPedido;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/itemPedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @PostMapping
    public ItemPedido adicionar(@RequestBody @Valid ItemPedido itemPedido) {
        return itemPedidoService.adicionar(itemPedido);
    }
}
