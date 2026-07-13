package br.com.fiap.application.usecase.restaurante;

import br.com.fiap.application.dto.CadastrarRestauranteInput;
import br.com.fiap.application.port.out.IRestauranteGateway;
import br.com.fiap.application.port.out.IUsuarioGateway;
import br.com.fiap.domain.entity.Restaurante;
import br.com.fiap.domain.entity.Usuario;
import br.com.fiap.domain.exception.UsuarioNaoEncontradoException;

public class CadastrarRestauranteUseCase {
    private final IRestauranteGateway restauranteGateway;
    private final IUsuarioGateway usuarioGateway;

    private CadastrarRestauranteUseCase(IRestauranteGateway restauranteGateway, IUsuarioGateway usuarioGateway) {
        this.restauranteGateway = restauranteGateway;
        this.usuarioGateway = usuarioGateway;
    }

    public static CadastrarRestauranteUseCase criar(IRestauranteGateway restauranteGateway, IUsuarioGateway usuarioGateway) {
        return new CadastrarRestauranteUseCase(restauranteGateway, usuarioGateway);
    }

    public Restaurante processar(CadastrarRestauranteInput input) {
        Usuario dono = this.usuarioGateway
                .buscarUsuarioPorId(input.donoId())
                .orElseThrow(() -> new UsuarioNaoEncontradoException(input.donoId()));
        Restaurante restaurante = Restaurante.criar(
                input.nome(),
                input.endereco(),
                input.tipoCozinha(),
                input.horarioFuncionamento(),
                dono
        );
        return this.restauranteGateway.salvarRestaurante(restaurante);
    }
}
