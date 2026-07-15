package br.com.felipefreitas.LogFel.infra.adapters.output.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(nullable = false, length = 30)
    private String status; // Ex: 'AGUARDANDO_ENVIO', 'EM_TRANSITO', 'ENTREGUE'

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_vendedor", nullable = false)
    private FuncionarioEntity vendedor;

    // Relacionamento: O cliente (Destino da entrega)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_cliente", nullable = false)
    private ClienteEntity cliente;

    // Relacionamento: O veículo que está fazendo esta entrega (pode ser nulo até ser despachado)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_veiculo")
    private VeiculoEntity veiculo;

    // Relacionamento: O funcionário/motorista que está fazendo esta entrega (pode ser nulo até ser despachado)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_motorista")
    private FuncionarioEntity motorista;

    // Relacionamento: Itens contidos neste pedido (Tabela intermediária de associação)
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoItemEntity> itens = new ArrayList<>();
}