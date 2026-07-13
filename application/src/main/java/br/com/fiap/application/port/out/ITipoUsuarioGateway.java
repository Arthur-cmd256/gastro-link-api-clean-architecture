package br.com.fiap.application.port.out;

import br.com.fiap.domain.entity.TipoUsuario;

import java.util.Optional;

public interface ITipoUsuarioGateway {
    TipoUsuario salvarTipoUsuario(TipoUsuario tipoUsuario);

    Optional<TipoUsuario> buscarTipoUsuarioPorId(Long id);

    TipoUsuario deletarTipoUsuario(Long id);
}
