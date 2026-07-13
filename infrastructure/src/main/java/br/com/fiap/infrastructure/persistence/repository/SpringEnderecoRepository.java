package br.com.fiap.infrastructure.persistence.repository;

import br.com.fiap.infrastructure.persistence.entity.EnderecoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringEnderecoRepository extends JpaRepository<EnderecoJpaEntity, Long> {
}

