package br.com.felipefreitas.LogFel.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private Long id;

    private String nome;

    private String documento;

    private String enderecoEntrega;

    private String cep;

    private String cidade;
}