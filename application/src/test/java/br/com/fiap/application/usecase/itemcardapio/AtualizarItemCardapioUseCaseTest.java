package br.com.fiap.application.usecase.itemcardapio;

import br.com.fiap.application.dto.AtualizarItemCardapioInput;
import br.com.fiap.application.factory.ItemCardapioFactory;
import br.com.fiap.application.port.out.IItemCardapioGateway;
import br.com.fiap.domain.entity.ItemCardapio;
import br.com.fiap.domain.exception.DadoObrigatorioException;
import br.com.fiap.domain.exception.ItemCardapioNaoEncontradoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AtualizarItemCardapioUseCaseTest {

    IItemCardapioGateway itemCardapioGateway;

    @BeforeEach
    void setUp() {
        this.itemCardapioGateway = Mockito.mock(IItemCardapioGateway.class);
    }

    @DisplayName("Atualizar item cardapio com sucesso")
    @Test
    void testAtualizarItemCardapioComSucesso() {
        ItemCardapio itemCardapioCadastrado = ItemCardapioFactory.criarItemCardapioPadrao();
        when(this.itemCardapioGateway.buscarItemCardapioPorId(Mockito.anyLong())).thenReturn(Optional.of(itemCardapioCadastrado));
        when(this.itemCardapioGateway.salvarItemCardapio(any(ItemCardapio.class))).thenAnswer(i -> i.getArgument(0));
        AtualizarItemCardapioInput input = new AtualizarItemCardapioInput(
                itemCardapioCadastrado.getId(),
                "Lasanha",
                "Lasanha de presunto e queijo",
                BigDecimal.valueOf(35.99),
                false,
                "/fotos/pratos/massas/lasanha.jpg"
        );

        ItemCardapio itemCardapioAtualizado = AtualizarItemCardapioUseCase
                .criar(this.itemCardapioGateway)
                .processar(input);

        verify(this.itemCardapioGateway, times(1)).buscarItemCardapioPorId(anyLong());
        verify(this.itemCardapioGateway, times(1)).salvarItemCardapio(any());
        assertNotNull(itemCardapioAtualizado);
        assertEquals(itemCardapioCadastrado.getId(), itemCardapioAtualizado.getId());
        assertEquals(input.nome(), itemCardapioAtualizado.getNome());
        assertEquals(input.disponibilidadeApenasRestaurante(), itemCardapioAtualizado.getDisponibilidadeApenasRestaurante());
    }

    @DisplayName("Atualizar item cardapio com erro (Item cardapio não encontrado)")
    @Test
    void testAtualizarItemCardapioComErroItemCardapioNaoEncontrado() {
        when(this.itemCardapioGateway.buscarItemCardapioPorId(Mockito.anyLong())).thenReturn(Optional.empty());
        Long idItemCardapio = 20L;
        AtualizarItemCardapioInput input = new AtualizarItemCardapioInput(
                idItemCardapio,
                "Lasanha",
                "Lasanha de presunto e queijo",
                BigDecimal.valueOf(35.99),
                false,
                "/fotos/pratos/massas/lasanha.jpg"
        );

        assertThatThrownBy(() -> {
            AtualizarItemCardapioUseCase
                    .criar(this.itemCardapioGateway)
                    .processar(input);
        })
                .isInstanceOf(ItemCardapioNaoEncontradoException.class)
                .hasMessage("ItemCardapio com ID " + idItemCardapio + " não foi encontrado.");
        verify(this.itemCardapioGateway, times(1)).buscarItemCardapioPorId(anyLong());
        verify(this.itemCardapioGateway, never()).salvarItemCardapio(any());
    }
}