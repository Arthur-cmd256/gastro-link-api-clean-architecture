package br.com.fiap.application.usecase.tipousuario;

import br.com.fiap.application.port.out.ITipoUsuarioGateway;

public class DeletarTipoUsuarioUseCase {
    private final ITipoUsuarioGateway tipoUsuarioGateway;

    private DeletarTipoUsuarioUseCase(ITipoUsuarioGateway tipoUsuarioGateway) {
        this.tipoUsuarioGateway = tipoUsuarioGateway;
    }

    public static DeletarTipoUsuarioUseCase criar(ITipoUsuarioGateway tipoUsuarioGateway) {
        return new DeletarTipoUsuarioUseCase(tipoUsuarioGateway);
    }

    public void processar(Long id) {
        this.tipoUsuarioGateway.deletarTipoUsuario(id);
    }
}
