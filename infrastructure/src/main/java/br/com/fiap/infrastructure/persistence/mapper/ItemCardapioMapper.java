package br.com.fiap.infrastructure.persistence.mapper;

import br.com.fiap.domain.entity.ItemCardapio;
import br.com.fiap.infrastructure.persistence.entity.ItemCardapioJpaEntity;

public class ItemCardapioMapper {

    public static ItemCardapioJpaEntity toJpaEntity(ItemCardapio itemCardapio) {
        if (itemCardapio == null) return null;

        ItemCardapioJpaEntity jpaEntity = new ItemCardapioJpaEntity();
        jpaEntity.setId(itemCardapio.getId());
        jpaEntity.setNome(itemCardapio.getNome());
        jpaEntity.setDescricao(itemCardapio.getDescricao());
        jpaEntity.setPreco(itemCardapio.getPreco());
        jpaEntity.setDisponibilidadeApenasRestaurante(itemCardapio.getDisponibilidadeApenasRestaurante());
        jpaEntity.setCaminhoFoto(itemCardapio.getCaminhoFoto());
        jpaEntity.setRestaurante(RestauranteMapper.toJpaEntity(itemCardapio.getRestaurante()));

        return jpaEntity;
    }

    public static ItemCardapio toDomain(ItemCardapioJpaEntity jpaEntity) {
        if (jpaEntity == null) return null;

        return ItemCardapio.criar(
                jpaEntity.getId(),
                jpaEntity.getNome(),
                jpaEntity.getDescricao(),
                jpaEntity.getPreco(),
                jpaEntity.getDisponibilidadeApenasRestaurante(),
                jpaEntity.getCaminhoFoto(),
                RestauranteMapper.toDomain(jpaEntity.getRestaurante())
        );
    }
}

