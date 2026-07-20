package br.com.felipefreitas.LogFel.infra.adapters.input.rest.controller;

import br.com.felipefreitas.LogFel.domain.model.Cargo;
import br.com.felipefreitas.LogFel.domain.service.CargoService;
import br.com.felipefreitas.LogFel.infra.adapters.input.rest.dto.cargo.CargoRequestDTO;
import br.com.felipefreitas.LogFel.infra.adapters.input.rest.dto.cargo.CargoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cargos")
@RequiredArgsConstructor
@Tag(name = "Controle de cargos",description = "Endpoint para tabela cargos")
public class CargoController {
    private final CargoService cargoService;

    @PostMapping
    @Operation(description = "Cadastrar cargos da empresa")
    public ResponseEntity<CargoResponseDTO> cadastrarCargo(@RequestBody @Valid CargoRequestDTO cargoRequestDTO) {

        // 1. Seu tratamento do Request (Perfeito!)
        String cargoTratado = cargoRequestDTO.getCargo().trim().toUpperCase();
        cargoRequestDTO.setCargo(cargoTratado);

        // 2. Transforma o DTO em Modelo de Domínio
        Cargo novoCargo = new Cargo();
        novoCargo.setCargo(cargoRequestDTO.getCargo());

        // 3. Chama as regras de negócio e salva através do Service
        Cargo cargoSalvo = cargoService.cadastrarCargo(novoCargo);

        // 4. Retorna o dado que de fato foi salvo no banco (o ideal para o POST é usar CREATED - status 201)
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CargoResponseDTO(cargoSalvo.getCargo()));
    }
}
