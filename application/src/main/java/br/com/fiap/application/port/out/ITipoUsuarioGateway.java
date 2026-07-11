package br.com.fiap.application.port.out;

import br.com.fiap.domain.entity.TipoUsuario;

public interface ITipoUsuarioGateway {
    TipoUsuario salvarTipoUsuario(TipoUsuario tipoUsuario);

    TipoUsuario buscarTipoUsuarioPorId(Long id);

    TipoUsuario deletarTipoUsuario(Long id);
}
