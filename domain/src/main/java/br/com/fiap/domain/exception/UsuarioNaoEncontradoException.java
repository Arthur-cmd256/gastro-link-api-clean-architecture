package br.com.fiap.domain.exception;

public class UsuarioNaoEncontradoException extends EntidadeNaoEncotradaException {
    public UsuarioNaoEncontradoException(Long id) {
        super("Usuario", id);
    }
}
