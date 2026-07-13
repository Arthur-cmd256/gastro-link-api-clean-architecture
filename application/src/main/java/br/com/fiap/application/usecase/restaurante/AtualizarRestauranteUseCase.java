package br.com.fiap.application.usecase.restaurante;

import br.com.fiap.application.dto.AtualizarRestauranteInput;
import br.com.fiap.application.port.out.IRestauranteGateway;
import br.com.fiap.application.port.out.IUsuarioGateway;
import br.com.fiap.domain.entity.Restaurante;
import br.com.fiap.domain.entity.Usuario;
import br.com.fiap.domain.exception.RestauranteNaoEncontradoException;
import br.com.fiap.domain.exception.UsuarioNaoEncontradoException;

public class AtualizarRestauranteUseCase {
    private final IRestauranteGateway restauranteGateway;
    private final IUsuarioGateway usuarioGateway;

    private AtualizarRestauranteUseCase(IRestauranteGateway restauranteGateway, IUsuarioGateway  usuarioGateway) {
        this.restauranteGateway = restauranteGateway;
        this.usuarioGateway = usuarioGateway;
    }

    public static AtualizarRestauranteUseCase criar(IRestauranteGateway restauranteGateway, IUsuarioGateway  usuarioGateway) {
        return new AtualizarRestauranteUseCase(restauranteGateway, usuarioGateway);
    }

    public Restaurante processar(AtualizarRestauranteInput atualizarEnderecoInput) {
        Long idRestaurante = atualizarEnderecoInput.id();
        Restaurante restaurante = this.restauranteGateway
                .buscarRestaurantePorId(idRestaurante).orElseThrow(() -> new RestauranteNaoEncontradoException(idRestaurante));
        Usuario donoRestaurante = restaurante.getDono();
        if (!donoRestaurante.getId().equals(atualizarEnderecoInput.donoId())) {
            donoRestaurante =  usuarioGateway
                    .buscarUsuarioPorId(atualizarEnderecoInput.donoId())
                    .orElseThrow(() -> new UsuarioNaoEncontradoException(atualizarEnderecoInput.donoId()));
        }
        Restaurante restauranteAtualizacao = Restaurante.criar(
                atualizarEnderecoInput.id(),
                atualizarEnderecoInput.nome(),
                atualizarEnderecoInput.endereco(),
                atualizarEnderecoInput.tipoCozinha(),
                atualizarEnderecoInput.horarioFuncionamento(),
                donoRestaurante
        );
        return this.restauranteGateway.salvarRestaurante(restauranteAtualizacao);
    }
}
