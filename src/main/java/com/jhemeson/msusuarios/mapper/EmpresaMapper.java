package com.jhemeson.msusuarios.mapper;

import com.jhemeson.msusuarios.dto.Empresa.EmpresaDTO;
import com.jhemeson.msusuarios.entity.Empresa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmpresaMapper {
    EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);
    Empresa toModel(EmpresaDTO empresaDTO);
    EmpresaDTO toDTO(Empresa empresa);
}
