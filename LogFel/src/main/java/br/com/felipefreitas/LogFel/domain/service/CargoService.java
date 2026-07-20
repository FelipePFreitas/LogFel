package br.com.felipefreitas.LogFel.domain.service;

import br.com.felipefreitas.LogFel.domain.model.Cargo;
import br.com.felipefreitas.LogFel.domain.ports.input.cargo.CadastrarCargoUseCase;
import br.com.felipefreitas.LogFel.domain.ports.input.cargo.ListCargoUseCase;
import br.com.felipefreitas.LogFel.domain.ports.input.cargo.UpdateCargoUseCase;
import br.com.felipefreitas.LogFel.domain.ports.output.cargo.CargoRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CargoService implements CadastrarCargoUseCase, UpdateCargoUseCase, ListCargoUseCase {

    private final CargoRepositoryPort cargoRepositoryPort;

    @Override
    public Cargo cadastrarCargo(Cargo cargo) {

        cargoRepositoryPort.findByName(cargo.getCargo())
                .ifPresent(c -> {
                    throw new RuntimeException("O cargo '" + c.getCargo() + "' já está cadastrado.");
                });

        if (cargo.getCargo().length() > 50) {
            throw new RuntimeException("Excesso de caracteres");
        }

        return cargoRepositoryPort.save(cargo);
    }

    @Override
    public Cargo atualizarCargo(Long id, Cargo cargo) {

        Cargo cargoExistente = cargoRepositoryPort.findById(id).orElseThrow(() -> new RuntimeException("Cargo" +
                " não encontrado"));

        cargoRepositoryPort.findByName(cargo.getCargo())
                .ifPresent(c -> {
                    if (!c.getId().equals(id)) {
                        throw new RuntimeException("O cargo '" + c.getCargo() + "' já está cadastrado.");
                    }
                });

        if (cargo.getCargo().length() > 50) {
            throw new RuntimeException("Excesso de caracteres");
        }

        cargoExistente.setCargo(cargo.getCargo());


        return cargoRepositoryPort.save(cargo);
    }

    @Override
    public List<Cargo> listCargos() {
        return cargoRepositoryPort.findAll();
    }
}
