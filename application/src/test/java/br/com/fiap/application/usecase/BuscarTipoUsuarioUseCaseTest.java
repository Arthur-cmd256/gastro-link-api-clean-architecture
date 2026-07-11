package br.com.fiap.application.usecase;

import br.com.fiap.application.port.out.ITipoUsuarioGateway;
import br.com.fiap.domain.entity.TipoUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class BuscarTipoUsuarioUseCaseTest {
    ITipoUsuarioGateway tipoUsuarioGateway;

    @BeforeEach
    void setUp() {
        this.tipoUsuarioGateway = mock(ITipoUsuarioGateway.class);
    }

    @Test
    void testBuscarTipoUsuarioComSucesso() {
        Long id = 1L;
        String nomeTipoUsuario = "Dono de Restaurante";
        TipoUsuario tipoUsuario = TipoUsuario.criar(id, nomeTipoUsuario);
        when(this.tipoUsuarioGateway.buscarTipoUsuarioPorId(any(Long.class))).thenReturn(tipoUsuario);

        TipoUsuario tipoUsuarioRetorno = BuscarTipoUsuarioUseCase.criar(this.tipoUsuarioGateway).processar(id);

        verify(this.tipoUsuarioGateway, times(1)).buscarTipoUsuarioPorId(any(Long.class));
        assertNotNull(tipoUsuarioRetorno);
        assertEquals(nomeTipoUsuario, tipoUsuarioRetorno.getNome());
    }
}