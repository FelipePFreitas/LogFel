package br.com.felipefreitas.LogFel.domain.service;

import br.com.felipefreitas.LogFel.domain.model.Cargo;
import br.com.felipefreitas.LogFel.domain.ports.input.cargo.CadastrarCargoUseCase;
import br.com.felipefreitas.LogFel.domain.ports.input.cargo.UpdateCargoUseCase;
import br.com.felipefreitas.LogFel.domain.ports.output.cargo.CargoRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CargoService implements CadastrarCargoUseCase, UpdateCargoUseCase {

    private final CargoRepositoryPort cargoRepositoryPort;

    @Override
    public Cargo cadastrarCargo(Cargo cargo) {

        cargoRepositoryPort.buscarCargosPorNome(cargo.getCargo())
                .ifPresent(c -> {
                    throw new RuntimeException("O cargo '" + c.getCargo() + "' já está cadastrado.");
                });

        if (cargo.getCargo().length() > 50) {
            throw new RuntimeException("Excesso de caracteres");
        }

        return cargoRepositoryPort.salvar(cargo);
    }

    @Override
    public Cargo atualizarCargo(Long id, Cargo cargo) {

        cargoRepositoryPort.buscarCargosPorNome(cargo.getCargo())
                .ifPresent(c -> {
                    if (c.getId().equals(id)) {
                        throw new RuntimeException("O cargo '" + c.getCargo() + "' já está cadastrado.");
                    }
                });

        Cargo cargoExistente = cargoRepositoryPort.buscarCargoPorId(id).orElseThrow(() -> new RuntimeException("Cargo" +
                " não encontrado"));

        if (cargo.getCargo().length() > 50) {
            throw new RuntimeException("Excesso de caracteres");
        }

        cargo.setId(cargoExistente.getId());

        return cargoRepositoryPort.salvar(cargo);
    }


}
