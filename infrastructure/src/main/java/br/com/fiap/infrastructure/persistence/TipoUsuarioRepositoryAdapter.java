package br.com.fiap.infrastructure.persistence;

import br.com.fiap.application.port.out.ITipoUsuarioGateway;
import br.com.fiap.domain.entity.TipoUsuario;

public class TipoUsuarioRepositoryAdapter implements ITipoUsuarioGateway {
    @Override
    public TipoUsuario salvarTipoUsuario(TipoUsuario tipoUsuario) {
        return null;
    }

    @Override
    public TipoUsuario buscarTipoUsuarioPorId(Long id) {
        return null;
    }

    @Override
    public TipoUsuario deletarTipoUsuario(Long id) {
        return null;
    }
}
