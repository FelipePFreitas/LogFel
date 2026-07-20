package br.com.felipefreitas.LogFel.domain.ports.input.login;

public interface UpdatePasswordLoginUseCase {
    void updatePassword (String email,String password);
}
