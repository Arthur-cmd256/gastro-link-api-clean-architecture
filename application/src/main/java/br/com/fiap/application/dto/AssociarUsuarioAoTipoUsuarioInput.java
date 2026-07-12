package br.com.fiap.application.dto;

public record AssociarUsuarioAoTipoUsuarioInput(
        Long idUsuario,
        Long idTipoUsuario
){
}
