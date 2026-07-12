package br.com.fiap.domain.entity;

public class TipoCozinha {
    private Long id;
    private String nome;

    private TipoCozinha(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static TipoCozinha criar(String nome){
        return new TipoCozinha(null, nome);
    }

    public static TipoCozinha criar(Long id, String nome){
        return new TipoCozinha(id, nome);
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }
}
