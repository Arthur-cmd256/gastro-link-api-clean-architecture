package br.com.fiap.domain.exception;

public class DadoObrigatorioException extends NegocioException {
    public DadoObrigatorioException(String campo) {
        super(String.format("O campo '%s' é obrigatório.", campo));
    }
}