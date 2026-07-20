package br.com.felipefreitas.LogFel.domain.ports.output.funcionario;

import br.com.felipefreitas.LogFel.domain.model.Funcionario;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepositoryPort {

    Funcionario save(Funcionario funcionario);

    Optional<Funcionario> findById (Long id);

    Optional<Funcionario> findByName (String nome);

    List<Funcionario> findAll();

    Funcionario deleteByName(String nome);
}
