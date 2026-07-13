package br.com.fiap.application.port.out;

import br.com.fiap.domain.entity.Restaurante;
import br.com.fiap.domain.entity.TipoUsuario;

import java.util.Optional;

public interface IRestauranteGateway {
    Restaurante salvarRestaurante(Restaurante restaurante);

    Optional<Restaurante> buscarRestaurantePorId(Long idRestaurante);

    void deletarRestaurante(Long idRestaurante);
}
