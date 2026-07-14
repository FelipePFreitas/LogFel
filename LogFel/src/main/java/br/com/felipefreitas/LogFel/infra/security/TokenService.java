package br.com.felipefreitas.LogFel.infra.security; // Ajuste para o pacote real do seu projeto

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    // Lê a chave secreta definida no seu application.properties para assinar o token
    @Value("${api.security.token.secret}")
    private String secret;

    private static final String ISSUER = "api-logfel";

    /**
     * Gera o token JWT para o usuário recém-autenticado.
     */
    public String gerarToken(String email) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(email) // Identificador do usuário (geralmente e-mail ou username)
                    .withExpiresAt(getdataExpiracao()) // Define quando o token expira
                    .sign(algoritmo);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Erro ao gerar o token JWT", exception);
        }
    }

    /**
     * Valida o token recebido no cabeçalho e extrai o e-mail (subject) dele.
     */
    public String getSubject(String tokenJWT) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            // Lança uma exceção se o token estiver expirado, inválido ou corrompido
            throw new RuntimeException("Token JWT inválido ou expirado!", exception);
        }
    }

    /**
     * Define o tempo de vida do token (ex: 2 horas de validade).
     * Ajustado para o fuso horário oficial de Brasília (UTC-3).
     */
    private Instant getdataExpiracao() {
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}