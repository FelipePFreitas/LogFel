package br.com.felipefreitas.LogFel.domain.ports.input.login;

import br.com.felipefreitas.LogFel.domain.model.Funcionario;
import br.com.felipefreitas.LogFel.domain.model.Login;

public interface CreateLoginUseCase {

    Login createLogin (String email, String password, Funcionario funcionario);
}
