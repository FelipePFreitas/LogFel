package br.com.felipefreitas.LogFel.infra.adapters.output.database.mapper;

import br.com.felipefreitas.LogFel.domain.model.Cargo;
import br.com.felipefreitas.LogFel.infra.adapters.output.database.entity.CargoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

// O componentModel = MappingConstants.ComponentModel.SPRING faz o MapStruct
// gerar o mapper como um @Component do Spring, pronto para ser injetado!
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CargoMapper {

    CargoEntity toEntity(Cargo domain);

    Cargo toDomain(CargoEntity entity);
}