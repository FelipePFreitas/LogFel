package br.com.felipefreitas.LogFel.domain.ports.output.cargo;

import br.com.felipefreitas.LogFel.domain.model.Cargo;

import java.util.List;
import java.util.Optional;

public interface CargoRepositoryPort {

    Cargo salvar(Cargo cargo);

    Optional<Cargo> buscarCargoPorId(Long id);

    List<Cargo> buscarTodosCargos();

    Optional<Cargo> buscarCargosPorNome(String cargo);

}
