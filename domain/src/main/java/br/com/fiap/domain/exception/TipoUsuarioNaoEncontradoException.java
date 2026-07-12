package br.com.fiap.domain.exception;

public class TipoUsuarioNaoEncontradoException extends EntidadeNaoEncotradaException {
    public TipoUsuarioNaoEncontradoException(Long id) {
        super("TipoUsuario", id);
    }
}
