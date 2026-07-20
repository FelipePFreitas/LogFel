package br.com.felipefreitas.LogFel.infra.adapters.output.database.adapter;

import br.com.felipefreitas.LogFel.domain.model.Cargo;
import br.com.felipefreitas.LogFel.domain.ports.output.cargo.CargoRepositoryPort;
import br.com.felipefreitas.LogFel.infra.adapters.output.database.entity.CargoEntity;
import br.com.felipefreitas.LogFel.infra.adapters.output.database.mapper.CargoMapper;
import br.com.felipefreitas.LogFel.infra.adapters.output.database.repository.CargoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CargoRepositoryAdapter implements CargoRepositoryPort {

    private final CargoRepository cargoRepository;
    private final CargoMapper cargoMapper;

    @Override
    public Cargo save(Cargo cargo) {
        CargoEntity entity = cargoMapper.toEntity(cargo);
        CargoEntity salvaEntity = cargoRepository.save(entity);
        return cargoMapper.toDomain(salvaEntity);
    }

    @Override
    public Optional<Cargo> findById(Long id) {
        return cargoRepository.findById(id)
                .map(cargoMapper::toDomain);
    }

    @Override
    public List<Cargo> findAll() {
        return cargoRepository.findAll()
                .stream()
                .map(cargoMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Cargo> findByName(String cargo) {
        return cargoRepository.findByCargoIgnoreCase(cargo).map(cargoMapper::toDomain);
    }
}
