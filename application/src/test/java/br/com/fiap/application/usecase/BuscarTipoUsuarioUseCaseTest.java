package br.com.fiap.application.usecase;

import br.com.fiap.application.port.out.ITipoUsuarioGateway;
import br.com.fiap.domain.entity.TipoUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BuscarTipoUsuarioUseCaseTest {
    ITipoUsuarioGateway tipoUsuarioGateway;

    @BeforeEach
    void setUp() {
        this.tipoUsuarioGateway = mock(ITipoUsuarioGateway.class);
    }

    @Test
    void testBuscarTipoUsuarioComSucesso() {
        String nomeTipoUsuario = "Dono de Restaurante";
        TipoUsuario tipoUsuario = TipoUsuario.criar(nomeTipoUsuario);
        when(this.tipoUsuarioGateway.buscaTipoUsuario(anyString())).thenReturn(tipoUsuario);

        TipoUsuario tipoUsuarioRetorno = BuscarTipoUsuarioUseCase.criar(this.tipoUsuarioGateway).processar(nomeTipoUsuario);

        assertNotNull(tipoUsuarioRetorno);
        assertEquals(nomeTipoUsuario, tipoUsuarioRetorno.getNome());
    }
}