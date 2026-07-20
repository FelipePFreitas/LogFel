package br.com.felipefreitas.LogFel.domain.model;

import br.com.felipefreitas.LogFel.infra.adapters.output.database.entity.PedidoEntity;
import br.com.felipefreitas.LogFel.infra.adapters.output.database.entity.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoItem {

    private Long id;

    private Pedido pedido;

    private Produto produto;

    private Integer quantidade;
}