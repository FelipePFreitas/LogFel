package br.com.felipefreitas.LogFel.infra.adapters.output.database.repository;

import br.com.felipefreitas.LogFel.infra.adapters.output.database.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long> {

    Optional<LoginEntity> findByEmail(String email);
}
