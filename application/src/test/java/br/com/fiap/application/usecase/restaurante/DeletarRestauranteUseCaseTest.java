package br.com.fiap.application.usecase.restaurante;

import br.com.fiap.application.port.out.IRestauranteGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class DeletarRestauranteUseCaseTest {

    IRestauranteGateway restauranteGateway;

    @BeforeEach
    void setUp() {
        this.restauranteGateway = Mockito.mock(IRestauranteGateway.class);
    }

    @DisplayName("Deletar restautante com sucesso")
    @Test
    void deletarRestauranteComSucesso() {
        Long idRestaurante = 1L;

        DeletarRestauranteUseCase.criar(restauranteGateway).processar(idRestaurante);

        verify(this.restauranteGateway, times(1)).deletarRestaurante(anyLong());
    }

}