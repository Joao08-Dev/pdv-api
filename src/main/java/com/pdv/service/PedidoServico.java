
package com.pdv.service;

import com.pdv.model.Pedido;
import com.pdv.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServico {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    public Pedido novo(Pedido pedido){
        return pedidoRepository.save(pedido);
    }
}
