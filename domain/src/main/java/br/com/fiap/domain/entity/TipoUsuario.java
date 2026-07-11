package br.com.fiap.domain.entity;

public class TipoUsuario {
    private Long id;
    private String nome;

    private TipoUsuario(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static TipoUsuario criar(String nome) {
        return new TipoUsuario(null, nome);
    }

    public String getNome() {
        return nome;
    }
}
