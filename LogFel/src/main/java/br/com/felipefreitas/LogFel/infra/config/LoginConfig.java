package br.com.felipefreitas.LogFel.infra.config;

import br.com.felipefreitas.LogFel.domain.ports.output.login.LoginRepositoryPort;
import br.com.felipefreitas.LogFel.domain.service.LoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Indica que esta classe gerencia Beans do Spring
public class LoginConfig {

    @Bean // Diz ao Spring para injetar e gerenciar a instância do seu Service puro
    public LoginService loginService(LoginRepositoryPort loginRepositoryPort) {

        return new LoginService(loginRepositoryPort);
    }
}