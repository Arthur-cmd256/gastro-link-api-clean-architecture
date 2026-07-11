package br.com.fiap.application.port.out;

import br.com.fiap.domain.entity.Usuario;

public interface IUsuarioGateway {
    Usuario buscarUsuarioPorId(Long idUsuario);

    Usuario salvarUsuario(Usuario usuario);
}
