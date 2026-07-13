package br.com.fiap.infrastructure.persistence.mapper;

import br.com.fiap.domain.entity.TipoUsuario;
import br.com.fiap.infrastructure.persistence.entity.TipoUsuarioJpaEntity;

public class TipoUsuarioMapper {

    public static TipoUsuarioJpaEntity toJpaEntity(TipoUsuario tipoUsuario) {
        if (tipoUsuario == null) return null;

        TipoUsuarioJpaEntity jpaEntity = new TipoUsuarioJpaEntity();
        jpaEntity.setId(tipoUsuario.getId());
        jpaEntity.setNome(tipoUsuario.getNome());

        return jpaEntity;
    }

    public static TipoUsuario toDomain(TipoUsuarioJpaEntity jpaEntity) {
        if (jpaEntity == null) return null;

        return TipoUsuario.criar(jpaEntity.getId(), jpaEntity.getNome());
    }
}

