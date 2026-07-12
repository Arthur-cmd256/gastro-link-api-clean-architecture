package br.com.fiap.application.usecase.itemcardapio;

import br.com.fiap.application.dto.AtualizarItemCardapioInput;
import br.com.fiap.application.port.out.IItemCardapioGateway;
import br.com.fiap.domain.entity.ItemCardapio;
import br.com.fiap.domain.exception.ItemCardapioNaoEncontradoException;

public class AtualizarItemCardapioUseCase {

    IItemCardapioGateway itemCardapioGateway;

    private AtualizarItemCardapioUseCase(IItemCardapioGateway itemCardapioGateway) {
        this.itemCardapioGateway = itemCardapioGateway;
    }

    public static AtualizarItemCardapioUseCase criar(IItemCardapioGateway itemCardapioGateway) {
        return new AtualizarItemCardapioUseCase(itemCardapioGateway);
    }

    public ItemCardapio processar(AtualizarItemCardapioInput atualizarItemCardapioInput) {
        ItemCardapio itemCardapio = this.itemCardapioGateway.buscarItemCardapioPorId(atualizarItemCardapioInput.id());
        if (itemCardapio == null) {
            throw new ItemCardapioNaoEncontradoException(atualizarItemCardapioInput.id());
        }
        ItemCardapio itemCardapioAtualizacao = ItemCardapio.criar(
                atualizarItemCardapioInput.id(),
                atualizarItemCardapioInput.nome(),
                atualizarItemCardapioInput.descricao(),
                atualizarItemCardapioInput.preco(),
                atualizarItemCardapioInput.disponibilidadeApenasRestaurante(),
                atualizarItemCardapioInput.caminhoFoto(),
                itemCardapio.getRestaurante()
        );
        return this.itemCardapioGateway.salvarItemCardapio(itemCardapioAtualizacao);
    }
}
