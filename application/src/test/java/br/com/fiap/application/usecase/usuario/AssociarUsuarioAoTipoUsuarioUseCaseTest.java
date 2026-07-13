package br.com.fiap.application.usecase.usuario;

import br.com.fiap.application.dto.AssociarUsuarioAoTipoUsuarioInput;
import br.com.fiap.application.port.out.ITipoUsuarioGateway;
import br.com.fiap.application.port.out.IUsuarioGateway;
import br.com.fiap.domain.entity.TipoUsuario;
import br.com.fiap.domain.entity.Usuario;
import br.com.fiap.domain.exception.TipoUsuarioNaoEncontradoException;
import br.com.fiap.domain.exception.UsuarioNaoEncontradoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AssociarUsuarioAoTipoUsuarioUseCaseTest {

    ITipoUsuarioGateway tipoUsuarioGateway;
    IUsuarioGateway usuarioGateway;
    AssociarUsuarioAoTipoUsuarioInput associarUsuarioAoTipoUsuarioInput;

    @BeforeEach
    void setUp() {
        this.tipoUsuarioGateway = mock(ITipoUsuarioGateway.class);
        this.usuarioGateway = mock(IUsuarioGateway.class);
        this.associarUsuarioAoTipoUsuarioInput = new AssociarUsuarioAoTipoUsuarioInput(10L, 20L);
    }

    @Test
    void testAssociarUsuarioAoTipoUsuarioComSucesso() {
        Usuario usuarioCadastrado = Usuario.criar(
                associarUsuarioAoTipoUsuarioInput.idUsuario(),
                "João",
                "joão@example.com",
                null
        );
        TipoUsuario tipoUsuarioCadastrado = TipoUsuario.criar(
                associarUsuarioAoTipoUsuarioInput.idTipoUsuario(),
                "Dono de Restaurante"
        );
        when(this.usuarioGateway.buscarUsuarioPorId(anyLong())).thenReturn(Optional.of(usuarioCadastrado));
        when(this.tipoUsuarioGateway.buscarTipoUsuarioPorId(anyLong())).thenReturn(Optional.of(tipoUsuarioCadastrado));
        when(this.usuarioGateway.salvarUsuario(any())).thenAnswer(i -> i.getArgument(0));

        Usuario usuarioAssociadoATipo = AssociarUsuarioAoTipoUsuarioUseCase
                .criar(this.tipoUsuarioGateway, this.usuarioGateway)
                .processar(associarUsuarioAoTipoUsuarioInput);

        verify(this.usuarioGateway, times(1)).salvarUsuario(any(Usuario.class));
        assertEquals(tipoUsuarioCadastrado.getNome(), usuarioAssociadoATipo.getTipoUsuarioNome());
    }

    @Test
    void testAssociarUsuarioAoTipoUsuarioComErroUsuarioNaoEncontrado() {
        when(this.usuarioGateway.buscarUsuarioPorId(anyLong())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> {
            AssociarUsuarioAoTipoUsuarioUseCase
                    .criar(this.tipoUsuarioGateway, this.usuarioGateway)
                    .processar(this.associarUsuarioAoTipoUsuarioInput);
        })
                .isInstanceOf(UsuarioNaoEncontradoException.class)
                .hasMessage("Usuario com ID "  + this.associarUsuarioAoTipoUsuarioInput.idUsuario() + " não foi encontrado.");

        verify(this.usuarioGateway, times(1)).buscarUsuarioPorId(any(Long.class));
        verify(this.usuarioGateway, never()).salvarUsuario(any(Usuario.class));
    }

    @Test
    void testAssociarUsuarioAoTipoUsuarioComErroTipoUsuarioNaoEncontrado() {
        Usuario usuarioCadastrado = Usuario.criar(
                this.associarUsuarioAoTipoUsuarioInput.idUsuario(),
                "João",
                "joão@example.com",
                null
        );
        when(this.usuarioGateway.buscarUsuarioPorId(anyLong())).thenReturn(Optional.of(usuarioCadastrado));
        when(this.tipoUsuarioGateway.buscarTipoUsuarioPorId(anyLong())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> {
            AssociarUsuarioAoTipoUsuarioUseCase
                    .criar(this.tipoUsuarioGateway, this.usuarioGateway)
                    .processar(this.associarUsuarioAoTipoUsuarioInput);
        })
                .isInstanceOf(TipoUsuarioNaoEncontradoException.class)
                .hasMessage("TipoUsuario com ID " + this.associarUsuarioAoTipoUsuarioInput.idTipoUsuario() + " não foi encontrado.");
        verify(this.usuarioGateway, times(1)).buscarUsuarioPorId(any(Long.class));
        verify(this.tipoUsuarioGateway, times(1)).buscarTipoUsuarioPorId(any(Long.class));
        verify(this.usuarioGateway, never()).salvarUsuario(any(Usuario.class));
    }
}