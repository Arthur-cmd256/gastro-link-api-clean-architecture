package br.com.fiap.domain.entity;

import br.com.fiap.domain.exception.DadoObrigatorioException;

import java.math.BigDecimal;

public class ItemCardapio {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Boolean disponibilidadeApenasRestaurante;
    private String caminhoFoto;
    private Restaurante restaurante;

    private ItemCardapio(Long id, String nome, String descricao, BigDecimal preco, Boolean disponibilidadeApenasRestaurante, String caminhoFoto, Restaurante restaurante) {
        if (nome == null) {
            throw new DadoObrigatorioException("nome");
        }
        if (descricao == null) {
            throw new DadoObrigatorioException("descricao");
        }
        if (preco == null) {
            throw new DadoObrigatorioException("preco");
        }
        if (disponibilidadeApenasRestaurante == null) {
            throw new DadoObrigatorioException("disponibilidade");
        }
        if (caminhoFoto == null) {
            throw new DadoObrigatorioException("caminho");
        }
        if (restaurante == null) {
            throw new DadoObrigatorioException("restaurante");
        }

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.disponibilidadeApenasRestaurante = disponibilidadeApenasRestaurante;
        this.caminhoFoto = caminhoFoto;
        this.restaurante = restaurante;
    }

    public static ItemCardapio criar(String nome, String descricao, BigDecimal preco, Boolean disponibilidadeApenasRestaurante, String caminhoFoto, Restaurante restaurante) {
        return new ItemCardapio(null, nome, descricao, preco, disponibilidadeApenasRestaurante, caminhoFoto, restaurante);
    }

    public static ItemCardapio criar(Long idItemCardapio,String nome, String descricao, BigDecimal preco, Boolean disponibilidadeApenasRestaurante, String caminhoFoto, Restaurante restaurante) {
        return new ItemCardapio(idItemCardapio, nome, descricao, preco, disponibilidadeApenasRestaurante, caminhoFoto, restaurante);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Boolean getDisponibilidadeApenasRestaurante() {
        return disponibilidadeApenasRestaurante;
    }

    public String getCaminhoFoto() {
        return caminhoFoto;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public String getNomeRestaurante() {
        return restaurante.getNome();
    }
}
