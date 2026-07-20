package br.com.felipefreitas.LogFel.infra.adapters.output.database.repository;

import br.com.felipefreitas.LogFel.infra.adapters.output.database.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {
}
