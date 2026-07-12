package br.com.fiap.application.port.out;

import br.com.fiap.domain.entity.ItemCardapio;

import java.util.List;

public interface IItemCardapioGateway {
    ItemCardapio salvarItemCardapio(ItemCardapio itemCardapio);

    List<ItemCardapio> buscarItensCardapioPorRestauranteId(Long idRestaurante);

    ItemCardapio buscarItemCardapioPorId(Long id);

    void deletarItemCardapio(Long idItemCardapio);
}
