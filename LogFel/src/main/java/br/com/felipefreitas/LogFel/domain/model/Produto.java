package br.com.felipefreitas.LogFel.domain.model;

import br.com.felipefreitas.LogFel.infra.adapters.output.database.entity.FornecedorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    private Double pesoKg;

    private Integer quantidadeEstoque;

    private Fornecedor fornecedor;
}