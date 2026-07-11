package br.com.fiap.application.usecase;

import br.com.fiap.application.port.out.ITipoUsuarioGateway;
import br.com.fiap.domain.entity.TipoUsuario;
import br.com.fiap.domain.exception.EntidadeNaoEncotradaException;

public class AtualizarTipoUsuarioUseCase {

    private final ITipoUsuarioGateway tipoUsuarioGateway;

    private AtualizarTipoUsuarioUseCase(ITipoUsuarioGateway tipoUsuarioGateway) {
        this.tipoUsuarioGateway = tipoUsuarioGateway;
    }

    public static AtualizarTipoUsuarioUseCase criar(ITipoUsuarioGateway tipoUsuarioGateway) {
        return new AtualizarTipoUsuarioUseCase(tipoUsuarioGateway);
    }

    public TipoUsuario processar(TipoUsuario tipoUsuarioAlterado) {
        Long idTipoUsuario = tipoUsuarioAlterado.getId();
        TipoUsuario tipoUsuario = this.tipoUsuarioGateway.buscarTipoUsuarioPorId(idTipoUsuario);
        if (tipoUsuario == null) {
            throw new EntidadeNaoEncotradaException("O tipo evento com o id " + idTipoUsuario + " não foi encontrado.");
        }
        return this.tipoUsuarioGateway.salvarTipoUsuario(tipoUsuarioAlterado);
    }
}
