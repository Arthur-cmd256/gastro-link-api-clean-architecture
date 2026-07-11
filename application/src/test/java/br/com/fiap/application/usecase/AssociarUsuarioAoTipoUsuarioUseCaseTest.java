package br.com.fiap.application.usecase;

import br.com.fiap.application.port.out.ITipoUsuarioGateway;
import br.com.fiap.application.port.out.IUsuarioGateway;
import br.com.fiap.domain.entity.TipoUsuario;
import br.com.fiap.domain.entity.Usuario;
import br.com.fiap.domain.exception.EntidadeNaoEncotradaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AssociarUsuarioAoTipoUsuarioUseCaseTest {

    ITipoUsuarioGateway tipoUsuarioGateway;
    IUsuarioGateway usuarioGateway;

    @BeforeEach
    void setUp() {
        this.tipoUsuarioGateway = mock(ITipoUsuarioGateway.class);
        this.usuarioGateway = mock(IUsuarioGateway.class);
    }

    @Test
    void testAssociarUsuarioAoTipoUsuarioComSucesso() {
        Long idUsuario = 10L;
        Long idTipoUsuario = 20L;
        Usuario usuarioCadastrado = Usuario.criar(
                idUsuario,
                "João",
                "joão@example.com",
                null
        );
        TipoUsuario tipoUsuarioCadastrado = TipoUsuario.criar(
                idTipoUsuario,
                "Dono de Restaurante"
        );
        when(this.usuarioGateway.buscarUsuarioPorId(anyLong())).thenReturn(usuarioCadastrado);
        when(this.tipoUsuarioGateway.buscarTipoUsuarioPorId(anyLong())).thenReturn(tipoUsuarioCadastrado);
        when(this.usuarioGateway.salvarUsuario(any())).thenAnswer(i -> i.getArgument(0));

        Usuario usuarioAssociadoATipo = AssociarUsuarioAoTipoUsuarioUseCase.criar(this.tipoUsuarioGateway, this.usuarioGateway).processar(idUsuario,  idTipoUsuario);

        verify(this.usuarioGateway, times(1)).salvarUsuario(any(Usuario.class));
        assertEquals(tipoUsuarioCadastrado.getNome(), usuarioAssociadoATipo.getTipoUsuarioNome());
    }

    @Test
    void testAssociarUsuarioAoTipoUsuarioComErroUsuarioNaoEncontrado() {
        Long idUsuario = 10L;
        Long idTipoUsuario = 20L;
        when(this.usuarioGateway.buscarUsuarioPorId(anyLong())).thenReturn(null);

        assertThatThrownBy(() -> {
            AssociarUsuarioAoTipoUsuarioUseCase.criar(this.tipoUsuarioGateway, this.usuarioGateway).processar(idUsuario,  idTipoUsuario);
        })
                .isInstanceOf(EntidadeNaoEncotradaException.class)
                .hasMessage("Usuario com o id "  + idUsuario + " nao encontrado");

        verify(this.usuarioGateway, times(1)).buscarUsuarioPorId(any(Long.class));
        verify(this.usuarioGateway, never()).salvarUsuario(any(Usuario.class));
    }

    @Test
    void testAssociarUsuarioAoTipoUsuarioComErroTipoUsuarioNaoEncontrado() {
        Long idUsuario = 10L;
        Usuario usuarioCadastrado = Usuario.criar(
                idUsuario,
                "João",
                "joão@example.com",
                null
        );
        Long idTipoUsuario = 20L;
        when(this.usuarioGateway.buscarUsuarioPorId(anyLong())).thenReturn(usuarioCadastrado);
        when(this.tipoUsuarioGateway.buscarTipoUsuarioPorId(anyLong())).thenReturn(null);

        assertThatThrownBy(() -> {
            AssociarUsuarioAoTipoUsuarioUseCase.criar(this.tipoUsuarioGateway, this.usuarioGateway).processar(idUsuario,  idTipoUsuario);
        })
                .isInstanceOf(EntidadeNaoEncotradaException.class)
                .hasMessage("Tipo usuario com o id " + idTipoUsuario + " nao encontrado");
        verify(this.usuarioGateway, times(1)).buscarUsuarioPorId(any(Long.class));
        verify(this.tipoUsuarioGateway, times(1)).buscarTipoUsuarioPorId(any(Long.class));
        verify(this.usuarioGateway, never()).salvarUsuario(any(Usuario.class));
    }
}