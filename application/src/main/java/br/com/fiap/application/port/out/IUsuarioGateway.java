package br.com.fiap.application.port.out;

import br.com.fiap.domain.entity.Usuario;

import java.util.Optional;

public interface IUsuarioGateway {
    Optional<Usuario> buscarUsuarioPorId(Long idUsuario);

    Usuario salvarUsuario(Usuario usuario);
}
