package com.jhemeson.msusuarios.mapper;

import com.jhemeson.msusuarios.dto.EmpresaDTO;
import com.jhemeson.msusuarios.entity.Empresa;
import org.mapstruct.factory.Mappers;

public interface EmpresaMapper {
    EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);
    Empresa toModel(EmpresaDTO empresaDTO);
    EmpresaDTO toDTO(Empresa empresa);
}
