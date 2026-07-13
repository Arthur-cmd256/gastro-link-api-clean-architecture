package br.com.fiap.infrastructure.persistence.entity;

import br.com.fiap.domain.entity.Restaurante;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tb_item_cardapio")
public class ItemCardapioJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private Boolean disponibilidadeApenasRestaurante;

    @Column(nullable = false)
    private String caminhoFoto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_restaurante", nullable = false)
    private RestauranteJpaEntity restaurante;
}
