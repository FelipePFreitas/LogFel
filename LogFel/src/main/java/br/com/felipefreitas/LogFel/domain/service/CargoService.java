package br.com.felipefreitas.LogFel.domain.service;

import br.com.felipefreitas.LogFel.domain.model.Cargo;
import br.com.felipefreitas.LogFel.domain.ports.output.CargoRepositoryPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CargoService {

    private final CargoRepositoryPort cargoRepositoryPort;

    public Cargo cadastrarCargo (Cargo cargo){

        cargoRepositoryPort.buscarCargosPorNome(cargo.getCargo())
            .ifPresent(c -> {
                throw new RuntimeException("O cargo '" + c.getCargo() + "' já está cadastrado.");
            });

        if (cargo.getCargo().length() > 50){
            throw new RuntimeException("Excesso de caracteres");
        }

        return cargoRepositoryPort.salvar(cargo);
    }

}
