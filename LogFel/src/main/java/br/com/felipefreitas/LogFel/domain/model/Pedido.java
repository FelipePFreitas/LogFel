package br.com.felipefreitas.LogFel.domain.model;

import br.com.felipefreitas.LogFel.infra.adapters.output.database.entity.ClienteEntity;
import br.com.felipefreitas.LogFel.infra.adapters.output.database.entity.FuncionarioEntity;
import br.com.felipefreitas.LogFel.infra.adapters.output.database.entity.PedidoItemEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    private Long id;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    private String status; // Ex: 'AGUARDANDO_ENVIO', 'EM_TRANSITO', 'ENTREGUE'

    private Funcionario vendedor;

    private ClienteEntity cliente;

    private Veiculo veiculo;

    private Funcionario motorista;

    private List<PedidoItem> itens = new ArrayList<>();
}