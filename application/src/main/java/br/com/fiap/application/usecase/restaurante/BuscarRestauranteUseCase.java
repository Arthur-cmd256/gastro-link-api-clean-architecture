package br.com.fiap.application.usecase.restaurante;

import br.com.fiap.application.port.out.IRestauranteGateway;
import br.com.fiap.domain.entity.Restaurante;
public class BuscarRestauranteUseCase {

    private final IRestauranteGateway restauranteGateway;

    private BuscarRestauranteUseCase(IRestauranteGateway restauranteGateway) {
        this.restauranteGateway = restauranteGateway;
    }

    public static BuscarRestauranteUseCase criar(IRestauranteGateway restauranteGateway) {
        return new BuscarRestauranteUseCase(restauranteGateway);
    }

    public Restaurante processar(Long idRestaurante) {
        return this.restauranteGateway
                .buscarRestaurantePorId(idRestaurante)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado com o ID: " + idRestaurante));
    }
}
