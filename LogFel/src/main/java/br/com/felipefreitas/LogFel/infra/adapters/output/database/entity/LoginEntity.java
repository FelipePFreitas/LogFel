package br.com.felipefreitas.LogFel.infra.adapters.output.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "login")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL) // adicionei o carregamento preguiçoso (lazy) no relacionamento. Isso evita que
    // o JPA faça um JOIN desnecessário buscando o usuário no banco toda vez que você só precisar validar o e-mail e a senha do login
    @JoinColumn(name = "fk_id_usuario", nullable = false)
    private FuncionarioEntity funcionario;

}
