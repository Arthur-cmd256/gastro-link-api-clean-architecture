package br.com.fiap.infrastructure.persistence.repository;

import br.com.fiap.infrastructure.persistence.entity.TipoUsuarioJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringTipoUsuarioRepository extends JpaRepository<TipoUsuarioJpaEntity, Long> {
}

