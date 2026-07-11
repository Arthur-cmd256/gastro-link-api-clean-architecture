package br.com.fiap.application.usecase;

import br.com.fiap.application.port.out.ITipoUsuarioGateway;
import br.com.fiap.domain.entity.TipoUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class CadastrarTipoUsuarioUseCaseTest {

    ITipoUsuarioGateway tipoUsuarioGateway;

    @BeforeEach
    void setUp() {
        this.tipoUsuarioGateway = mock(ITipoUsuarioGateway.class);
    }

    @DisplayName("Cadastrar tipo usuario com sucesso")
    @Test
    void testCadastrarTipoUsuarioComSucesso() {
        String nomeTipoUsuario = "Dono de Restaurante";
        when(this.tipoUsuarioGateway.salvarTipoUsuario(any(TipoUsuario.class))).thenAnswer(i -> i.getArgument(0));

        final TipoUsuario tipoUsuario = CadastrarTipoUsuarioUseCase.criar(this.tipoUsuarioGateway).processar(nomeTipoUsuario);

        verify(this.tipoUsuarioGateway, times(1)).salvarTipoUsuario(any(TipoUsuario.class));
        assertNotNull(tipoUsuario);
        assertEquals(nomeTipoUsuario, tipoUsuario.getNome());
    }
}