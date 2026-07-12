package br.com.fiap.application.usecase.tipousuario;

import br.com.fiap.application.port.out.ITipoUsuarioGateway;
import br.com.fiap.domain.entity.TipoUsuario;

public class BuscarTipoUsuarioUseCase {

    private final ITipoUsuarioGateway tipoUsuarioGateway;

    private BuscarTipoUsuarioUseCase(ITipoUsuarioGateway tipoUsuarioGateway) {
        this.tipoUsuarioGateway = tipoUsuarioGateway;
    }

    public static BuscarTipoUsuarioUseCase criar(ITipoUsuarioGateway tipoUsuarioGateway) {
        return new BuscarTipoUsuarioUseCase(tipoUsuarioGateway);
    }

    public TipoUsuario processar(Long idTipoUsuario) {
        return this.tipoUsuarioGateway.buscarTipoUsuarioPorId(idTipoUsuario);
    }
}
