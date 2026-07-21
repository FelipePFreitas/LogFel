package br.com.felipefreitas.LogFel.infra.adapters.input.rest.dto.login;

import lombok.Builder;

@Builder
public record LoginResponseDTO(Long id,String email) {
}
