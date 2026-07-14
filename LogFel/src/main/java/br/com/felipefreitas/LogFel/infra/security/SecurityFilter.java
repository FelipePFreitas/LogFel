package br.com.felipefreitas.LogFel.infra.security; // Ajuste para o pacote real do seu projeto

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    ///DO: Quando você criar a classe de Usuário e o UserRepository,
    // precisaremos injetar o UserRepository aqui para carregar o usuário do banco.
    // @Autowired
    // private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // 1. Recupera o token que veio no cabeçalho Authorization da requisição
        String tokenJWT = recuperarToken(request);

        if (tokenJWT != null) {
            try {
                // 2. Valida o token e extrai o "subject" (que é o e-mail do usuário)
                String subject = tokenService.getSubject(tokenJWT);

                // 3. TODO: Quando tivermos o banco pronto, vamos buscar o usuário para recuperar suas "Roles" (permissões):
                // var usuario = userRepository.findByEmail(subject);

                // Por hora, criamos uma autenticação provisória para o Spring não barrar
                // Assim que criarmos a entidade de Usuário, substituiremos o 'null' abaixo pelo 'usuario' e suas authorities.
                var authentication = new UsernamePasswordAuthenticationToken(subject, null, null);

                // 4. Força a autenticação no contexto de segurança do Spring para essa requisição
                SecurityContextHolder.getContext().setAuthentication(authentication);

            } catch (Exception e) {
                // Se o token for inválido, não autentica a requisição (o Spring Security vai barrar mais à frente)
                System.out.println("Falha na autenticação do token: " + e.getMessage());
            }
        }

        // 5. Continua o fluxo normal da requisição (passando para o próximo filtro ou controller)
        filterChain.doFilter(request, response);
    }

    /**
     * Extrai o token de dentro do cabeçalho "Authorization: Bearer <token>"
     */
    private String recuperarToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.replace("Bearer ", "").trim();
        }
        return null;
    }
}