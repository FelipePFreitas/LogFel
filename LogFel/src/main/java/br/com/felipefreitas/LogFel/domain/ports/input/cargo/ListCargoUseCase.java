package br.com.felipefreitas.LogFel.domain.ports.input.cargo;

import br.com.felipefreitas.LogFel.domain.model.Cargo;

import java.util.List;

public interface ListCargoUseCase {

    List<Cargo> listCargos();
}
