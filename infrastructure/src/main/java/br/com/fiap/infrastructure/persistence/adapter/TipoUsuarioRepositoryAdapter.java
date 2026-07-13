package br.com.fiap.infrastructure.persistence.adapter;

import br.com.fiap.application.port.out.ITipoUsuarioGateway;
import br.com.fiap.domain.entity.TipoUsuario;
import br.com.fiap.infrastructure.persistence.mapper.TipoUsuarioMapper;
import br.com.fiap.infrastructure.persistence.entity.TipoUsuarioJpaEntity;
import br.com.fiap.infrastructure.persistence.repository.SpringTipoUsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TipoUsuarioRepositoryAdapter implements ITipoUsuarioGateway {

    private final SpringTipoUsuarioRepository springRepository;

    public TipoUsuarioRepositoryAdapter(SpringTipoUsuarioRepository springRepository) {
        this.springRepository = springRepository;
    }

    @Override
    public TipoUsuario salvarTipoUsuario(TipoUsuario tipoUsuario) {
        TipoUsuarioJpaEntity jpaEntity = TipoUsuarioMapper.toJpaEntity(tipoUsuario);
        TipoUsuarioJpaEntity saved = springRepository.save(jpaEntity);
        return TipoUsuarioMapper.toDomain(saved);
    }

    @Override
    public Optional<TipoUsuario> buscarTipoUsuarioPorId(Long id) {
        return springRepository.findById(id).map(TipoUsuarioMapper::toDomain);
    }

    @Override
    public TipoUsuario deletarTipoUsuario(Long id) {
        TipoUsuarioJpaEntity entity = springRepository.findById(id).orElse(null);
        if (entity != null) {
            springRepository.deleteById(id);
        }
        return TipoUsuarioMapper.toDomain(entity);
    }
}

