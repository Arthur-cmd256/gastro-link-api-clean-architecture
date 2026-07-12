package br.com.fiap.application.usecase.itemcardapio;

import br.com.fiap.application.port.out.IItemCardapioGateway;

public class DeletarItemCardapioUseCase {
    private final IItemCardapioGateway itemCardapioGateway;

    private DeletarItemCardapioUseCase(IItemCardapioGateway itemCardapioGateway) {
        this.itemCardapioGateway = itemCardapioGateway;
    }

    public static DeletarItemCardapioUseCase create(IItemCardapioGateway itemCardapioGateway) {
        return new DeletarItemCardapioUseCase(itemCardapioGateway);
    }

    public void processar(Long idItemCardapio) {
        this.itemCardapioGateway.deletarItemCardapio(idItemCardapio);
    }
}
