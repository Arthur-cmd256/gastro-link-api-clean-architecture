package br.com.fiap.application.dto;

import br.com.fiap.domain.entity.Endereco;
import br.com.fiap.domain.entity.TipoCozinha;

public record AtualizarRestauranteInput(
        Long id,
        String nome,
        Endereco endereco,
        TipoCozinha tipoCozinha,
        String horarioFuncionamento,
        Long donoId
) {
}
