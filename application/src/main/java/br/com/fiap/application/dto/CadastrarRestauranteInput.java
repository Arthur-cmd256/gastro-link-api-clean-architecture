package br.com.fiap.application.dto;

import br.com.fiap.domain.entity.Endereco;
import br.com.fiap.domain.entity.TipoCozinha;

public record CadastrarRestauranteInput(
        String nome,
        Long donoId,
        Endereco endereco,
        TipoCozinha tipoCozinha,
        String horarioFuncionamento
) {
}
