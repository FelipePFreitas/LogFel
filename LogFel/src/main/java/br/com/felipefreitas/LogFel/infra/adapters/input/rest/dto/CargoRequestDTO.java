package br.com.felipefreitas.LogFel.infra.adapters.input.rest.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CargoRequestDTO {

    @NotBlank(message = "Não poder ser nulo e nem em branco")
    private String cargo;

}