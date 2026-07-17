package br.com.felipefreitas.LogFel.infra.config;

import br.com.felipefreitas.LogFel.domain.ports.output.cargo.CargoRepositoryPort;
import br.com.felipefreitas.LogFel.domain.service.CargoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Indica que esta classe gerencia Beans do Spring
public class CargoConfig {

    @Bean // Diz ao Spring para injetar e gerenciar a instância do seu Service puro
    public CargoService cargoService(CargoRepositoryPort cargoRepositoryPort) {
        // O Spring automaticamente encontra o seu CargoRepositoryAdapter
        // (porque ele é um @Component que implementa CargoRepositoryPort)
        // e passa ele aqui no construtor do seu Service!
        return new CargoService(cargoRepositoryPort);
    }
}