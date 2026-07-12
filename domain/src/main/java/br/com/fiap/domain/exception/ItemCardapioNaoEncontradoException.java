package br.com.fiap.domain.exception;

public class ItemCardapioNaoEncontradoException extends EntidadeNaoEncotradaException {
    public ItemCardapioNaoEncontradoException(Long id) {
        super("ItemCardapio", id);
    }
}
