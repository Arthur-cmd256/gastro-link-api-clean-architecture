package br.com.fiap.application.usecase.tipousuario;

import br.com.fiap.application.port.out.ITipoUsuarioGateway;
import br.com.fiap.domain.entity.TipoUsuario;

public class CadastrarTipoUsuarioUseCase {

    private final ITipoUsuarioGateway tipoUsuarioGateway;

    private CadastrarTipoUsuarioUseCase(ITipoUsuarioGateway tipoUsuarioGateway) {
        this.tipoUsuarioGateway = tipoUsuarioGateway;
    }

    public static CadastrarTipoUsuarioUseCase criar(ITipoUsuarioGateway tipoUsuarioGateway) {
        return new CadastrarTipoUsuarioUseCase(tipoUsuarioGateway);
    }

    public TipoUsuario processar(String nome) {
        TipoUsuario tipoUsuario = TipoUsuario.criar(nome);
        return this.tipoUsuarioGateway.salvarTipoUsuario(tipoUsuario);
    }
}
