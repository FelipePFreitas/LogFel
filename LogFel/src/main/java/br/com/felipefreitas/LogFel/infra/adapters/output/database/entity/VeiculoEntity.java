package br.com.felipefreitas.LogFel.infra.adapters.output.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "veiculos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VeiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String ano;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private boolean sendoUsado = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_funcionario",nullable = true)
    private FuncionarioEntity funcionarioEntity;

}
