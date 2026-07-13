package br.com.fiap.application.port.out;

import br.com.fiap.domain.entity.ItemCardapio;

import java.util.List;
import java.util.Optional;

public interface IItemCardapioGateway {
    ItemCardapio salvarItemCardapio(ItemCardapio itemCardapio);

    List<ItemCardapio> buscarItensCardapioPorRestauranteId(Long idRestaurante);

    Optional<ItemCardapio> buscarItemCardapioPorId(Long id);

    void deletarItemCardapio(Long idItemCardapio);
}
