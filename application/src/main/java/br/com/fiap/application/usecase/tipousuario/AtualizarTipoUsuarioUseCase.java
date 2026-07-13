package br.com.fiap.application.usecase.tipousuario;

import br.com.fiap.application.dto.AtualizarTipoUsuarioInput;
import br.com.fiap.application.port.out.ITipoUsuarioGateway;
import br.com.fiap.domain.entity.TipoUsuario;
import br.com.fiap.domain.exception.TipoUsuarioNaoEncontradoException;

public class AtualizarTipoUsuarioUseCase {

    private final ITipoUsuarioGateway tipoUsuarioGateway;

    private AtualizarTipoUsuarioUseCase(ITipoUsuarioGateway tipoUsuarioGateway) {
        this.tipoUsuarioGateway = tipoUsuarioGateway;
    }

    public static AtualizarTipoUsuarioUseCase criar(ITipoUsuarioGateway tipoUsuarioGateway) {
        return new AtualizarTipoUsuarioUseCase(tipoUsuarioGateway);
    }

    public TipoUsuario processar(AtualizarTipoUsuarioInput atualizarTipoUsuarioInput) {
        Long idTipoUsuario = atualizarTipoUsuarioInput.id();
        TipoUsuario tipoUsuario = this.tipoUsuarioGateway
                .buscarTipoUsuarioPorId(idTipoUsuario)
                .orElseThrow(() -> new TipoUsuarioNaoEncontradoException(idTipoUsuario));
        TipoUsuario tipoUsuarioAlterado = TipoUsuario.criar(
                atualizarTipoUsuarioInput.id(),
                atualizarTipoUsuarioInput.nome()
        );
        return this.tipoUsuarioGateway.salvarTipoUsuario(tipoUsuarioAlterado);
    }
}
