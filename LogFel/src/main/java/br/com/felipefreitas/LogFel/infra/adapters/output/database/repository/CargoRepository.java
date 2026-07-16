package br.com.felipefreitas.LogFel.infra.adapters.output.database.repository;

import br.com.felipefreitas.LogFel.infra.adapters.output.database.entity.CargoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CargoRepository extends JpaRepository<CargoEntity,Long> {

    Optional<CargoEntity> findByCargoPorNome(String cargo);
}
