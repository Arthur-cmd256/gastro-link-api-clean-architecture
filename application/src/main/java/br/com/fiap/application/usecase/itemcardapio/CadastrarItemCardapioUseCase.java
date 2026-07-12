package br.com.fiap.application.usecase.itemcardapio;

import br.com.fiap.application.dto.CadastrarItemCardapioInput;
import br.com.fiap.application.port.out.IItemCardapioGateway;
import br.com.fiap.application.port.out.IRestauranteGateway;
import br.com.fiap.domain.entity.ItemCardapio;
import br.com.fiap.domain.entity.Restaurante;
import br.com.fiap.domain.exception.DadoObrigatorioException;
import br.com.fiap.domain.exception.RestauranteNaoEncontradoException;

public class CadastrarItemCardapioUseCase {

    IItemCardapioGateway itemCardapioGateway;
    IRestauranteGateway restauranteGateway;

    private CadastrarItemCardapioUseCase(IItemCardapioGateway itemCardapioGateway,  IRestauranteGateway restauranteGateway) {
        this.itemCardapioGateway = itemCardapioGateway;
        this.restauranteGateway = restauranteGateway;
    }

    public static CadastrarItemCardapioUseCase criar(IItemCardapioGateway itemCardapioGateway,  IRestauranteGateway restauranteGateway) {
        return new CadastrarItemCardapioUseCase(itemCardapioGateway,  restauranteGateway);
    }

    public ItemCardapio processar(CadastrarItemCardapioInput cadastrarItemCardapioInput) {
        Long idRestaurante = cadastrarItemCardapioInput.restauranteId();
        if (idRestaurante == null) {
            throw new DadoObrigatorioException("restauranteId");
        }
        Restaurante restaurante = this.restauranteGateway.buscarRestaurantePorId(idRestaurante);

        if (restaurante == null) {
            throw new RestauranteNaoEncontradoException(idRestaurante);
        }

        ItemCardapio itemCardapio = ItemCardapio.criar(
                cadastrarItemCardapioInput.nome(),
                cadastrarItemCardapioInput.descricao(),
                cadastrarItemCardapioInput.preco(),
                cadastrarItemCardapioInput.disponibilidadeApenasRestaurante(),
                cadastrarItemCardapioInput.caminhoFoto(),
                restaurante
        );

        return this.itemCardapioGateway.salvarItemCardapio(itemCardapio);
    }
}
