package br.com.felipefreitas.LogFel.domain.service;

import br.com.felipefreitas.LogFel.domain.model.Funcionario;
import br.com.felipefreitas.LogFel.domain.model.Login;
import br.com.felipefreitas.LogFel.domain.ports.input.login.CreateLoginUseCase;
import br.com.felipefreitas.LogFel.domain.ports.input.login.DeleteLoginUseCase;
import br.com.felipefreitas.LogFel.domain.ports.input.login.UpdatePasswordLoginUseCase;
import br.com.felipefreitas.LogFel.domain.ports.output.funcionario.FuncionarioRepositoryPort;
import br.com.felipefreitas.LogFel.domain.ports.output.login.LoginRepositoryPort;
import br.com.felipefreitas.LogFel.domain.utils.CpfCnpjValidatorUtils;
import br.com.felipefreitas.LogFel.domain.utils.EmailValidatorUtils;
import br.com.felipefreitas.LogFel.domain.utils.PasswordValidatorUtils;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginService implements CreateLoginUseCase, DeleteLoginUseCase, UpdatePasswordLoginUseCase {

    private final LoginRepositoryPort loginRepositoryPort;
    private final FuncionarioRepositoryPort funcionarioRepositoryPort;


    @Override
    public Login createLogin(String email, String password, Funcionario funcionario) {

        if (!EmailValidatorUtils.isValidEmail(email)) {
            throw new RuntimeException("Formato email inválido");
        }

        loginRepositoryPort.findByEmail(email).ifPresent(loginExistente -> {
            throw new RuntimeException("Email informado ja está cadastrado");
        });

        if (!PasswordValidatorUtils.isValidPassword(password)) {
            throw new RuntimeException("Formato de senha inválido");
        }

        if (funcionario == null || !CpfCnpjValidatorUtils.isValidCpf(funcionario.getCpf())) {
            throw new RuntimeException("CPF do funcionário é inválido ou não informado");
        }

        Login login = Login.builder()
                .email(email)
                .password(password)
                .funcionario(funcionario)
                .build();

        return loginRepositoryPort.save(login);

    }


    @Override
    public void deleteLogin(Long id) {

        Login loginExistente = loginRepositoryPort.findById(id).orElseThrow(() -> new RuntimeException("Id login não " +
                "encontrado"));

        loginRepositoryPort.delete(loginExistente);

    }

    @Override
    public void updatePassword(String email, String password) {
        Login loginExistente = loginRepositoryPort.findByEmail(email).orElseThrow(() -> new RuntimeException("Login " +
                "não encontrado"));

        if (!PasswordValidatorUtils.isValidPassword(password)) {
            throw new RuntimeException("Formato de senha inválido");
        }

        loginExistente.setPassword(password);

        loginRepositoryPort.save(loginExistente);

    }
}
