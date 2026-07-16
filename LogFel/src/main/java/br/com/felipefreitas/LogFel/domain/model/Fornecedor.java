package br.com.felipefreitas.LogFel.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fornecedor {

    private Long id;

    private String razaoSocial;

    private String cnpj;

    private String telefone;
}