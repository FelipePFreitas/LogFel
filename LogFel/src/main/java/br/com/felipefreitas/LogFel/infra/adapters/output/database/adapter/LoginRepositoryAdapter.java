package br.com.felipefreitas.LogFel.infra.adapters.output.database.adapter;

import br.com.felipefreitas.LogFel.domain.model.Login;
import br.com.felipefreitas.LogFel.domain.ports.output.login.LoginRepositoryPort;
import br.com.felipefreitas.LogFel.infra.adapters.output.database.entity.LoginEntity;
import br.com.felipefreitas.LogFel.infra.adapters.output.database.mapper.LoginMapper;
import br.com.felipefreitas.LogFel.infra.adapters.output.database.repository.LoginRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class LoginRepositoryAdapter implements LoginRepositoryPort {

    private final LoginRepository loginRepository;
    private final LoginMapper loginMapper;

    @Override
    public Login save(Login login) {
        LoginEntity loginEntity = loginMapper.toEntity(login);
        LoginEntity salvaLoginEntity = loginRepository.save(loginEntity);
        return loginMapper.toDomain(salvaLoginEntity);
    }

    @Override
    public Optional<Login> findByEmail(String email) {
        return loginRepository.findByEmail(email).map(loginMapper::toDomain);
    }

    @Override
    public Optional<Login> findById(Long id) {
        return loginRepository.findById(id).map(loginMapper::toDomain);
    }

    @Override
    public void delete(Login login) {
        LoginEntity loginEntity = loginMapper.toEntity(login);
        loginRepository.delete(loginEntity);
    }
}
