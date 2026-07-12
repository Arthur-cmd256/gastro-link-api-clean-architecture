package br.com.fiap.domain.entity;

public class Endereco {
    private Long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    private Endereco(Long id, String logradouro, String complemento, String numero, String bairro, String cidade, String uf, String cep) {
        this.id = id;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public static Endereco criar(String logradouro, String complemento, String numero, String bairro, String cidade, String uf, String cep){
        return new Endereco(null, logradouro, complemento, numero, bairro, cidade, uf, cep);
    }

    public Long getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }
}
