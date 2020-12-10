package com.jhemeson.msusuarios.mapper;

import com.jhemeson.msusuarios.dto.Projeto.ProjetoDTO;
import com.jhemeson.msusuarios.entity.Projeto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjetoMapper {

    ProjetoMapper INSTANCE = Mappers.getMapper(ProjetoMapper.class);

    Projeto toModel(ProjetoDTO bookDTO);

    ProjetoDTO toDTO(Projeto book);
}
