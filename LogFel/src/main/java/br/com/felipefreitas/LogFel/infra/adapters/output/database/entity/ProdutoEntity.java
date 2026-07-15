package br.com.felipefreitas.LogFel.infra.adapters.output.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 255)
    private String descricao;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(nullable = false)
    private Double pesoKg; // Importante para calcular se o veículo suporta a carga

    @Column(nullable = false)
    private Integer quantidadeEstoque;

    // Relacionamento: Muitos produtos pertencem a um fornecedor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_fornecedor", nullable = false)
    private FornecedorEntity fornecedor;
}