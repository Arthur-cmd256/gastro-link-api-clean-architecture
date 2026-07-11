package br.com.fiap.application.usecase;

import br.com.fiap.application.port.out.ITipoUsuarioGateway;
import br.com.fiap.domain.entity.TipoUsuario;
import br.com.fiap.domain.exception.EntidadeNaoEncotradaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AtualizarTipoUsuarioUseCaseTest {
    ITipoUsuarioGateway tipoUsuarioGateway;

    @BeforeEach
    void setUp() {
        this.tipoUsuarioGateway = mock(ITipoUsuarioGateway.class);
    }

    @Test
    void testAtualizarTipoUsuarioComSucesso() {
        TipoUsuario tipoUsuario = TipoUsuario.criar(1L, "Dono");
        when(this.tipoUsuarioGateway.buscarTipoUsuarioPorId(any(Long.class))).thenReturn(tipoUsuario);
        when(this.tipoUsuarioGateway.salvarTipoUsuario(any(TipoUsuario.class))).thenAnswer(i -> i.getArgument(0));
        TipoUsuario tipoUsuarioAtualizacao = TipoUsuario.criar(1L, "Cliente");

        TipoUsuario tipoUsuarioAtualizado = AtualizarTipoUsuarioUseCase.criar(this.tipoUsuarioGateway).processar(tipoUsuarioAtualizacao);

        Assertions.assertEquals(tipoUsuarioAtualizacao.getNome(), tipoUsuarioAtualizado.getNome());

        verify(this.tipoUsuarioGateway, times(1)).buscarTipoUsuarioPorId(any(Long.class));
    }

    @Test
    void testAtualizarTipoUsuarioComErroEntidadeNaoEncontrada() {
        when(this.tipoUsuarioGateway.buscarTipoUsuarioPorId(any(Long.class))).thenReturn(null);
        Long idTipoUsuario = 1L;
        TipoUsuario tipoUsuarioAtualizacao = TipoUsuario.criar(idTipoUsuario, "Cliente");

        assertThatThrownBy(() -> AtualizarTipoUsuarioUseCase.criar(this.tipoUsuarioGateway).processar(tipoUsuarioAtualizacao))
                .isInstanceOf(EntidadeNaoEncotradaException.class)
                .hasMessage("O tipo evento com o id "+ idTipoUsuario +" não foi encontrado.");

        verify(this.tipoUsuarioGateway, never()).salvarTipoUsuario(any(TipoUsuario.class));
    }
}