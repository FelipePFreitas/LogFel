package br.com.felipefreitas.LogFel.domain.ports.input.cargo;

import br.com.felipefreitas.LogFel.domain.model.Cargo;

public interface CadastrarCargoUseCase {

    Cargo cadastrarCargo (Cargo cargo);
}
