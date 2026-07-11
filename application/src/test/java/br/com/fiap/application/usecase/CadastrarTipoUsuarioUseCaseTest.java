package br.com.fiap.application.usecase;

import br.com.fiap.application.port.out.ITipoUsuarioGateway;
import br.com.fiap.domain.entity.TipoUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        when(this.tipoUsuarioGateway.salvar(any(TipoUsuario.class))).thenAnswer(i -> i.getArgument(0));

        final TipoUsuario tipoUsuario = CadastrarTipoUsuarioUseCase.criar(this.tipoUsuarioGateway).processar(nomeTipoUsuario);

        assertNotNull(tipoUsuario);
        assertEquals(nomeTipoUsuario, tipoUsuario.getNome());
    }
}