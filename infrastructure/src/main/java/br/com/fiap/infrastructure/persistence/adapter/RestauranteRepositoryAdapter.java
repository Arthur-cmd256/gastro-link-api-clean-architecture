package br.com.fiap.infrastructure.persistence.adapter;

import br.com.fiap.application.port.out.IRestauranteGateway;
import br.com.fiap.domain.entity.Restaurante;
import br.com.fiap.infrastructure.persistence.entity.RestauranteJpaEntity;
import br.com.fiap.infrastructure.persistence.mapper.RestauranteMapper;
import br.com.fiap.infrastructure.persistence.repository.SpringRestauranteRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RestauranteRepositoryAdapter implements IRestauranteGateway {
    private final SpringRestauranteRepository springRepository;

    public RestauranteRepositoryAdapter(SpringRestauranteRepository springRepository) {
        this.springRepository = springRepository;
    }

    @Override
    public Restaurante salvarRestaurante(Restaurante restaurante) {
        RestauranteJpaEntity jpaEntity = RestauranteMapper.toJpaEntity(restaurante);
        RestauranteJpaEntity entitySalva = springRepository.save(jpaEntity);
        return RestauranteMapper.toDomain(entitySalva);
    }

    @Override
    public Optional<Restaurante> buscarRestaurantePorId(Long idRestaurante) {
         return springRepository.findById(idRestaurante).map(RestauranteMapper::toDomain);
    }

    @Override
    public void deletarRestaurante(Long idRestaurante) {
        springRepository.deleteById(idRestaurante);
    }
}
