package br.com.fiap.application.usecase.tipousuario;

import br.com.fiap.application.port.out.ITipoUsuarioGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class DeletarTipoUsuarioUseCaseTest {
    ITipoUsuarioGateway tipoUsuarioGateway;

    @BeforeEach
    void setUp() {
        this.tipoUsuarioGateway = mock(ITipoUsuarioGateway.class);
    }

    @Test
    void testApagarTipoUsuarioComSucesso() {
        Long id = 1L;
        when(this.tipoUsuarioGateway.deletarTipoUsuario(any(Long.class))).thenReturn(null);

        DeletarTipoUsuarioUseCase.criar(this.tipoUsuarioGateway).processar(id);

        verify(this.tipoUsuarioGateway, times(1)).deletarTipoUsuario(any(Long.class));
    }
}