package br.com.fiap.infrastructure.persistence.repository;

import br.com.fiap.infrastructure.persistence.entity.RestauranteJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringRestauranteRepository extends JpaRepository<RestauranteJpaEntity, Long> {
}
