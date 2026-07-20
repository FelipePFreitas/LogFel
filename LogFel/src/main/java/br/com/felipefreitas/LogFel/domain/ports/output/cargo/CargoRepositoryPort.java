package br.com.felipefreitas.LogFel.domain.ports.output.cargo;

import br.com.felipefreitas.LogFel.domain.model.Cargo;

import java.util.List;
import java.util.Optional;

public interface CargoRepositoryPort {

    Cargo save(Cargo cargo);

    Optional<Cargo> findById(Long id);

    List<Cargo> findAll();

    Optional<Cargo> findByName(String cargo);

}
