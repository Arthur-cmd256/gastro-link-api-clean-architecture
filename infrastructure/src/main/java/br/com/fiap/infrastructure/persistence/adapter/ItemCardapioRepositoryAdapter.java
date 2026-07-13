package br.com.fiap.infrastructure.persistence.adapter;

import br.com.fiap.application.port.out.IItemCardapioGateway;
import br.com.fiap.domain.entity.ItemCardapio;
import br.com.fiap.infrastructure.persistence.mapper.ItemCardapioMapper;
import br.com.fiap.infrastructure.persistence.entity.ItemCardapioJpaEntity;
import br.com.fiap.infrastructure.persistence.repository.SpringItemCardapioRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ItemCardapioRepositoryAdapter implements IItemCardapioGateway {

    private final SpringItemCardapioRepository springRepository;

    public ItemCardapioRepositoryAdapter(SpringItemCardapioRepository springRepository) {
        this.springRepository = springRepository;
    }

    @Override
    public ItemCardapio salvarItemCardapio(ItemCardapio itemCardapio) {
        ItemCardapioJpaEntity jpaEntity = ItemCardapioMapper.toJpaEntity(itemCardapio);
        ItemCardapioJpaEntity saved = springRepository.save(jpaEntity);
        return ItemCardapioMapper.toDomain(saved);
    }

    @Override
    public List<ItemCardapio> buscarItensCardapioPorRestauranteId(Long idRestaurante) {
        return springRepository.findByRestauranteId(idRestaurante)
                .stream()
                .map(ItemCardapioMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ItemCardapio> buscarItemCardapioPorId(Long id) {
        return springRepository.findById(id).map(ItemCardapioMapper::toDomain);
    }

    @Override
    public void deletarItemCardapio(Long idItemCardapio) {
        springRepository.deleteById(idItemCardapio);
    }
}

