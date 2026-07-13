package br.com.fiap.infrastructure.persistence.adapter;

import br.com.fiap.application.port.out.IUsuarioGateway;
import br.com.fiap.domain.entity.Usuario;
import br.com.fiap.infrastructure.persistence.entity.UsuarioJpaEntity;
import br.com.fiap.infrastructure.persistence.mapper.UsuarioMapper;
import br.com.fiap.infrastructure.persistence.repository.SpringUsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioRepositoryAdapter implements IUsuarioGateway {

    private final SpringUsuarioRepository springRepository;

    public UsuarioRepositoryAdapter(SpringUsuarioRepository springRepository) {
        this.springRepository = springRepository;
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorId(Long idUsuario) {
        return springRepository.findById(idUsuario).map(UsuarioMapper::toDomain);
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        UsuarioJpaEntity jpaEntity = UsuarioMapper.toJpaEntity(usuario);
        UsuarioJpaEntity saved = springRepository.save(jpaEntity);
        return UsuarioMapper.toDomain(saved);
    }
}

