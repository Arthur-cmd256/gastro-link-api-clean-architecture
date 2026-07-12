package br.com.fiap.application.usecase.itemcardapio;

import br.com.fiap.application.port.out.IItemCardapioGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class DeletarItemCardapioUseCaseTest {

    IItemCardapioGateway itemCardapioGateway;

    @BeforeEach
    void setUp() {
        this.itemCardapioGateway = Mockito.mock(IItemCardapioGateway.class);
    }

    @DisplayName("Deletar item cardapio com sucesso")
    @Test
    void testDeletarItemCardapioComSucesso() {
        Long itemCardapioId = 1L;

        DeletarItemCardapioUseCase.create(this.itemCardapioGateway).processar(itemCardapioId);

        verify(this.itemCardapioGateway, times(1)).deletarItemCardapio(anyLong());
    }

}