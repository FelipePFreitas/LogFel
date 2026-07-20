package br.com.felipefreitas.LogFel.domain.ports.output.login;

import br.com.felipefreitas.LogFel.domain.model.Login;

import java.util.Optional;


public interface LoginRepositoryPort {

    Login save(Login login);

    Optional<Login> findByEmail(String email);

    Optional<Login> findById(Long id);

    void delete(Login login);

}
