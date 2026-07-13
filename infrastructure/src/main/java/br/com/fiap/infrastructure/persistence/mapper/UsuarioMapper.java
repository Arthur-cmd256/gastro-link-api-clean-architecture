package br.com.fiap.infrastructure.persistence.mapper;

import br.com.fiap.domain.entity.Usuario;
import br.com.fiap.infrastructure.persistence.entity.UsuarioJpaEntity;

public class UsuarioMapper {

    public static UsuarioJpaEntity toJpaEntity(Usuario usuario) {
        if (usuario == null) return null;

        UsuarioJpaEntity jpaEntity = new UsuarioJpaEntity();
        jpaEntity.setId(usuario.getId());
        jpaEntity.setNome(usuario.getNome());
        jpaEntity.setEnderecoDeEmail(usuario.getEnderecoDeEmail());
        // TODO: Implementar mapeamento de TipoUsuario quando necessário

        return jpaEntity;
    }

    public static Usuario toDomain(UsuarioJpaEntity jpaEntity) {
        if (jpaEntity == null) return null;

        return Usuario.criar(
                jpaEntity.getId(),
                jpaEntity.getNome(),
                jpaEntity.getEnderecoDeEmail(),
                TipoUsuarioMapper.toDomain(jpaEntity.getTipoUsuario())
        );
    }
}

