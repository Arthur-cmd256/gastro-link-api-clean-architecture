package br.com.fiap.application.port.out;

import br.com.fiap.domain.entity.Restaurante;
import br.com.fiap.domain.entity.TipoUsuario;

public interface IRestauranteGateway {
    Restaurante salvarRestaurante(Restaurante restaurante);

    Restaurante buscarRestaurantePorId(Long idRestaurante);

    void deletarRestaurante(Long idRestaurante);
}
