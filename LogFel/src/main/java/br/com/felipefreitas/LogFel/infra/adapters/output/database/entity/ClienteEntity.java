package br.com.felipefreitas.LogFel.infra.adapters.output.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, unique = true, length = 18)
    private String documento; // Pode aceitar CPF ou CNPJ

    // Dados cruciais para a entrega do Pedido
    @Column(nullable = false, length = 150)
    private String enderecoEntrega;

    @Column(nullable = false, length = 9)
    private String cep;

    @Column(length = 100)
    private String cidade;
}