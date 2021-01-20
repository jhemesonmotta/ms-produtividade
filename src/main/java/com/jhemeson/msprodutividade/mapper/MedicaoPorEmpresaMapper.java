package com.jhemeson.msprodutividade.mapper;

import com.jhemeson.msprodutividade.dto.MedicaoPorEmpresa.MedicaoPorEmpresaDTO;
import com.jhemeson.msprodutividade.entity.MedicaoPorEmpresa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicaoPorEmpresaMapper {
	MedicaoPorEmpresaMapper INSTANCE = Mappers.getMapper(MedicaoPorEmpresaMapper.class);
	MedicaoPorEmpresa toModel(MedicaoPorEmpresaDTO medicaoPorEmpresaDTO);
	MedicaoPorEmpresaDTO toDTO(MedicaoPorEmpresa medicaoPorEmpresa);
}
