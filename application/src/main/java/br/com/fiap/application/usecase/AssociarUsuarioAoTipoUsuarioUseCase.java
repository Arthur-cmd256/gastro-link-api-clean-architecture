package br.com.fiap.application.usecase;

import br.com.fiap.application.port.out.ITipoUsuarioGateway;
import br.com.fiap.application.port.out.IUsuarioGateway;
import br.com.fiap.domain.entity.TipoUsuario;
import br.com.fiap.domain.entity.Usuario;
import br.com.fiap.domain.exception.EntidadeNaoEncotradaException;

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

    public Usuario processar(Long idUsuario, Long idTipoUsuario) {
        Usuario usuarioBuscado = this.usuarioGateway.buscarUsuarioPorId(idUsuario);
        if (usuarioBuscado == null) {
            throw new EntidadeNaoEncotradaException("Usuario com o id "  + idUsuario + " nao encontrado");
        }
        TipoUsuario tipoUsuarioBuscado = this.tipoUsuarioGateway.buscarTipoUsuarioPorId(idTipoUsuario);
        if (tipoUsuarioBuscado == null) {
            throw new EntidadeNaoEncotradaException("Tipo usuario com o id " + idTipoUsuario + " nao encontrado");
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
