package br.com.fiap.application.usecase.usuario;

import br.com.fiap.application.dto.AssociarUsuarioAoTipoUsuarioInput;
import br.com.fiap.application.port.out.ITipoUsuarioGateway;
import br.com.fiap.application.port.out.IUsuarioGateway;
import br.com.fiap.domain.entity.TipoUsuario;
import br.com.fiap.domain.entity.Usuario;
import br.com.fiap.domain.exception.TipoUsuarioNaoEncontradoException;
import br.com.fiap.domain.exception.UsuarioNaoEncontradoException;

public class AssociarUsuarioAoTipoUsuarioUseCase {
    private final ITipoUsuarioGateway tipoUsuarioGateway;
    private final IUsuarioGateway usuarioGateway;

    private AssociarUsuarioAoTipoUsuarioUseCase(ITipoUsuarioGateway tipoUsuarioGateway,  IUsuarioGateway usuarioGateway) {
        this.tipoUsuarioGateway = tipoUsuarioGateway;
        this.usuarioGateway = usuarioGateway;
    }

    public static AssociarUsuarioAoTipoUsuarioUseCase criar(ITipoUsuarioGateway tipoUsuarioGateway,  IUsuarioGateway usuarioGateway) {
        return new AssociarUsuarioAoTipoUsuarioUseCase(tipoUsuarioGateway, usuarioGateway);
    }

    public Usuario processar(AssociarUsuarioAoTipoUsuarioInput associarUsuarioAoTipoUsuarioInput) {
        Long idUsuario = associarUsuarioAoTipoUsuarioInput.idUsuario();
        Long idTipoUsuario = associarUsuarioAoTipoUsuarioInput.idTipoUsuario();
        Usuario usuarioBuscado = this.usuarioGateway.buscarUsuarioPorId(idUsuario);
        if (usuarioBuscado == null) {
            throw new UsuarioNaoEncontradoException(idUsuario);
        }
        TipoUsuario tipoUsuarioBuscado = this.tipoUsuarioGateway.buscarTipoUsuarioPorId(idTipoUsuario);
        if (tipoUsuarioBuscado == null) {
            throw new TipoUsuarioNaoEncontradoException(idTipoUsuario);
        }
        Usuario usuarioComTipo = Usuario.criar(
                usuarioBuscado.getId(),
                usuarioBuscado.getNome(),
                usuarioBuscado.getEnderecoDeEmail(),
                tipoUsuarioBuscado
        );
        return this.usuarioGateway.salvarUsuario(usuarioComTipo);
    }
}
