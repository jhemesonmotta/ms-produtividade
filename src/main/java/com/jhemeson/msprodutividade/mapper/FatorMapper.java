package com.jhemeson.msprodutividade.mapper;

import com.jhemeson.msprodutividade.dto.Fator.FatorDTO;
import com.jhemeson.msprodutividade.entity.Fator;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FatorMapper {
	FatorMapper INSTANCE = Mappers.getMapper(FatorMapper.class);
	Fator toModel(FatorDTO fatorDTO);
	FatorDTO toDTO(Fator fator);
}
