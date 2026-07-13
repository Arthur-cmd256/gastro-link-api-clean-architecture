package br.com.fiap.infrastructure.persistence.repository;

import br.com.fiap.infrastructure.persistence.entity.ItemCardapioJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringItemCardapioRepository extends JpaRepository<ItemCardapioJpaEntity, Long> {
	java.util.List<ItemCardapioJpaEntity> findByRestauranteId(Long restauranteId);
}

