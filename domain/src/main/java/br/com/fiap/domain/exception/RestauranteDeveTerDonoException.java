package br.com.fiap.domain.exception;

public class RestauranteDeveTerDonoException extends NegocioException {
    public RestauranteDeveTerDonoException() {
        super("Todo restaurante deve estar associado a um usuário proprietário.");
    }
}