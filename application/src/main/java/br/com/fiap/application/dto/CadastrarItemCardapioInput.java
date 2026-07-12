package br.com.fiap.application.dto;

import br.com.fiap.domain.entity.Restaurante;

import java.math.BigDecimal;

public record CadastrarItemCardapioInput(
        String nome,
        String descricao,
        BigDecimal preco,
        Boolean disponibilidadeApenasRestaurante,
        String caminhoFoto,
        Long restauranteId
) {
}
