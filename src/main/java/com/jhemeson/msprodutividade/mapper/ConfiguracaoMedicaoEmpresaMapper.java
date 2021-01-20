package com.jhemeson.msprodutividade.mapper;

import com.jhemeson.msprodutividade.dto.ConfiguracaoMedicaoEmpresa.ConfiguracaoMedicaoEmpresaDTO;
import com.jhemeson.msprodutividade.entity.ConfiguracaoMedicaoEmpresa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ConfiguracaoMedicaoEmpresaMapper {
	ConfiguracaoMedicaoEmpresaMapper INSTANCE = Mappers.getMapper(ConfiguracaoMedicaoEmpresaMapper.class);
	ConfiguracaoMedicaoEmpresa toModel(ConfiguracaoMedicaoEmpresaDTO configuracaoMedicaoEmpresaDTO);
	ConfiguracaoMedicaoEmpresaDTO toDTO(ConfiguracaoMedicaoEmpresa configuracaoMedicaoEmpresa);
}
