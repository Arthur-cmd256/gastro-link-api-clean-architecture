package br.com.fiap.application.usecase.restaurante;

import br.com.fiap.application.port.out.IRestauranteGateway;

public class DeletarRestauranteUseCase {
    private final IRestauranteGateway restauranteGateway;

    private DeletarRestauranteUseCase(IRestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    public static DeletarRestauranteUseCase criar(IRestauranteGateway restauranteGateway) {
        return new DeletarRestauranteUseCase(restauranteGateway);
    }

    public void processar(Long idRestaurante) {
        this.restauranteGateway.deletarRestaurante(idRestaurante);
    }
}
