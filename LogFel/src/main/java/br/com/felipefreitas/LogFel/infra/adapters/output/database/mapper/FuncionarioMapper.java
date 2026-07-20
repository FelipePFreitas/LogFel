package br.com.felipefreitas.LogFel.infra.adapters.output.database.mapper;

import br.com.felipefreitas.LogFel.domain.model.Funcionario;
import br.com.felipefreitas.LogFel.infra.adapters.output.database.entity.FuncionarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FuncionarioMapper {

    FuncionarioEntity toEntity(Funcionario domain);

    Funcionario toDomain(FuncionarioEntity entity);
}
