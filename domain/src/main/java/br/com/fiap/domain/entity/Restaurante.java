package br.com.fiap.domain.entity;

import br.com.fiap.domain.exception.DadoObrigatorioException;
import br.com.fiap.domain.exception.RestauranteDeveTerDonoException;

public class Restaurante {
    private Long id;
    private String nome;
    private Endereco endereco;
    private TipoCozinha tipoCozinha;
    private String horarioFuncionamento;
    private Usuario dono;

    private Restaurante(Long id, String nome, Endereco endereco, TipoCozinha tipoCozinha, String horarioFuncionamento, Usuario dono) {
        if (nome == null || nome.isBlank()) {
            throw new DadoObrigatorioException("Nome do restaurante");
        }
        if (dono == null) {
            throw new RestauranteDeveTerDonoException();
        }

        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.tipoCozinha = tipoCozinha;
        this.horarioFuncionamento = horarioFuncionamento;
        this.dono = dono;
    }

    public static Restaurante criar(String nome, Endereco endereco, TipoCozinha tipoCozinha, String horarioFuncionamento, Usuario dono ) {
        return new Restaurante(null, nome, endereco, tipoCozinha, horarioFuncionamento, dono);
    }

    public static Restaurante criar(Long id, String nome, Endereco endereco, TipoCozinha tipoCozinha, String horarioFuncionamento, Usuario dono ) {
        return new Restaurante(id, nome, endereco, tipoCozinha, horarioFuncionamento, dono);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public String getNomeDono() {
        return dono.getNome();
    }

    public String getNomeTipoCozinha() {
        return tipoCozinha.getNome();
    }

    public Usuario getDono() {
        return dono;
    }
}
