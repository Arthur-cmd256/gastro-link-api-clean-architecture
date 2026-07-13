package br.com.fiap.infrastructure.persistence.repository;

import br.com.fiap.infrastructure.persistence.entity.TipoCozinhaJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringTipoCozinhaRepository extends JpaRepository<TipoCozinhaJpaEntity, Long> {
}

