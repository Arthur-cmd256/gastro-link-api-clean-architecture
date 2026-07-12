package br.com.fiap.application.dto;

import java.math.BigDecimal;

public record AtualizarItemCardapioInput(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        Boolean disponibilidadeApenasRestaurante,
        String caminhoFoto
) {
}
