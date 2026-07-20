package br.com.felipefreitas.LogFel.infra.adapters.output.database.mapper;

import br.com.felipefreitas.LogFel.domain.model.Login;
import br.com.felipefreitas.LogFel.infra.adapters.output.database.entity.LoginEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {FuncionarioMapper.class})
public interface LoginMapper {

    LoginEntity toEntity(Login domain);

    Login toDomain(LoginEntity entity);
}
