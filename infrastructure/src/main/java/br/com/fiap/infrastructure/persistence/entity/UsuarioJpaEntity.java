package br.com.fiap.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tb_usuario")
public class UsuarioJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String enderecoDeEmail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_usuario")
    private TipoUsuarioJpaEntity tipoUsuario;

    @OneToMany(mappedBy = "dono", fetch = FetchType.LAZY)
    private Set<RestauranteJpaEntity> restaurantes;

    public UsuarioJpaEntity() {
    }
}