package br.com.fiap.domain.entity;

public class Usuario {
    private Long id;
    private String nome;
    private String enderecoDeEmail;
    private TipoUsuario tipoUsuario;

    private Usuario(Long id, String nome, String enderecoDeEmail, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nome = nome;
        this.enderecoDeEmail = enderecoDeEmail;
        this.tipoUsuario = tipoUsuario;
    }

    public static Usuario criar(String nome, String enderecoDeEmail, TipoUsuario tipoUsuario) {
        return new Usuario(null, nome, enderecoDeEmail, tipoUsuario);
    }
}
