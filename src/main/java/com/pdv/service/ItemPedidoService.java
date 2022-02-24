package com.pdv.service;

import com.pdv.model.Ingrediente;
import com.pdv.model.ItemPedido;
import com.pdv.repository.ComponenteRepository;
import com.pdv.repository.IngredienteRepository;
import com.pdv.repository.ItemPedidoRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;
    @Autowired
    private ComponenteRepository componenteRepository;
    @Autowired
    private IngredienteRepository ingredienteRepository;
    private final List<Ingrediente> estoqueAtualizado = new ArrayList<>();

    public ItemPedido adicionar(ItemPedido itemPedido) {
        //busca componente pelo id do produto
        componenteRepository.produtoId(itemPedido.getProduto().getId()).forEach((componente) -> {
            double newQuantidade = itemPedido.getQuantidade().doubleValue() * componente.getQuantidadeUsada().doubleValue();
            double oldQuantidadeEstoque = componente.getIngrediente().getQuantidadeEstoque().doubleValue();
            double newQuantidadeEstoque = componente.getIngrediente().getQuantidadeEstoque().doubleValue() - newQuantidade;
            Ingrediente ingrediente = componente.getIngrediente();
            if (newQuantidade <= oldQuantidadeEstoque) {
                //atualiza quantidade estoque
                ingrediente.setQuantidadeEstoque(BigDecimal.valueOf(newQuantidadeEstoque));
                estoqueAtualizado.add(ingrediente);
            } else {
                //limpa lista de ingredientes caso tenha estoque em falta 
                estoqueAtualizado.clear();
                throw new UnsupportedOperationException("Ingridiente " + componente.getIngrediente().getNome() + " está com estoque insuficiente.");
            }

        });
        //atualiza estoque dos ingredientes usado para compor o produto
        if (!estoqueAtualizado.isEmpty()) {
            estoqueAtualizado.forEach((_ingrendiente) -> {
                //salve cada ingrediente com estoque atualizado
                ingredienteRepository.save(_ingrendiente);
            });
        }
        return itemPedidoRepository.save(itemPedido);
    }
}
