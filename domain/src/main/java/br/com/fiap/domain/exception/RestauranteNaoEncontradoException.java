package br.com.fiap.domain.exception;

public class RestauranteNaoEncontradoException extends EntidadeNaoEncotradaException {
    public RestauranteNaoEncontradoException(Long id) {
        super("Restaurante", id);
    }
}
