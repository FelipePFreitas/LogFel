package br.com.felipefreitas.LogFel.infra.adapters.output.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fornecedores")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FornecedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String razaoSocial;

    @Column(nullable = false, unique = true, length = 18)
    private String cnpj;

    @Column(length = 100)
    private String telefone;
}