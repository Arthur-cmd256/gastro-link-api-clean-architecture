package br.com.fiap.infrastructure.persistence.repository;

import br.com.fiap.infrastructure.persistence.entity.UsuarioJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringUsuarioRepository extends JpaRepository<UsuarioJpaEntity, Long> {
}

