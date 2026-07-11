package br.com.fiap.application.port.out;

import br.com.fiap.domain.entity.TipoUsuario;

public interface ITipoUsuarioGateway {
    TipoUsuario salvar(TipoUsuario tipoUsuario);

    TipoUsuario buscaTipoUsuario(String nome);
}
