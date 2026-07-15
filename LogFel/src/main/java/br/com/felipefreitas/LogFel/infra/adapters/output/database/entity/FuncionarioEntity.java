package br.com.felipefreitas.LogFel.infra.adapters.output.database.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 50)
    private String endereco;

    @Column(nullable = false, length = 50)
    private String numero;

    @Column(nullable = false, length = 50)
    private String cep;

    @Column(nullable = false, length = 50)
    private String bairro;

    @Column(nullable = false, length = 50)
    private String cidade;

    @Column(nullable = false, length = 2)
    private String estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_role", nullable = false)
    private RoleEntity roleEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_cargo", nullable = false)
    private CargoEntity cargo;
}
