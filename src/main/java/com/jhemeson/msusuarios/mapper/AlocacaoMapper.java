package com.jhemeson.msusuarios.mapper;

import com.jhemeson.msusuarios.dto.Alocacao.AlocacaoDTO;
import com.jhemeson.msusuarios.entity.Alocacao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlocacaoMapper {
    AlocacaoMapper INSTANCE = Mappers.getMapper(AlocacaoMapper.class);
    Alocacao toModel(AlocacaoDTO alocacaoDTO);
    AlocacaoDTO toDTO(Alocacao alocacao);
}
