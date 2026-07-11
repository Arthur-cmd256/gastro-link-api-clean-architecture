package br.com.fiap.domain.entity;

import java.math.BigDecimal;

public class ItemCardapio {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean disponibilidadeApenasRestaurante;
    private String caminhoFoto;
}
