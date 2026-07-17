package br.com.felipefreitas.LogFel.domain.ports.input.cargo;

import br.com.felipefreitas.LogFel.domain.model.Cargo;

public interface UpdateCargoUseCase {

    Cargo atualizarCargo (Long id, Cargo cargo);
}
