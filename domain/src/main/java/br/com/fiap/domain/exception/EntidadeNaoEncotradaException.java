package br.com.fiap.domain.exception;

public class EntidadeNaoEncotradaException extends RuntimeException {
    public EntidadeNaoEncotradaException(String message) {
        super(message);
    }
}
