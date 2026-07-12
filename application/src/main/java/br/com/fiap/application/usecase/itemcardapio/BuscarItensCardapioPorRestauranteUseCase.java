package br.com.fiap.application.usecase.itemcardapio;

import br.com.fiap.application.port.out.IItemCardapioGateway;
import br.com.fiap.domain.entity.ItemCardapio;

import java.util.List;

public class BuscarItensCardapioPorRestauranteUseCase {
    private final IItemCardapioGateway itemCardapioGateway;

    private BuscarItensCardapioPorRestauranteUseCase(IItemCardapioGateway itemCardapioGateway) {
        this.itemCardapioGateway = itemCardapioGateway;
    }

    public static BuscarItensCardapioPorRestauranteUseCase criar(IItemCardapioGateway itemCardapioGateway) {
        return new BuscarItensCardapioPorRestauranteUseCase(itemCardapioGateway);
    }

    public List<ItemCardapio> processar(Long idRestaurante) {
        return this.itemCardapioGateway.buscarItensCardapioPorRestauranteId(idRestaurante);
    }
}
