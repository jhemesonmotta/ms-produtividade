package com.jhemeson.msprodutividade.mapper;

import com.jhemeson.msprodutividade.dto.FatorMedidoPorPessoa.FatorMedidoPorPessoaDTO;
import com.jhemeson.msprodutividade.entity.FatorMedidoPorPessoa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FatorMedidoPorPessoaMapper {
	FatorMedidoPorPessoaMapper INSTANCE = Mappers.getMapper(FatorMedidoPorPessoaMapper.class);
	FatorMedidoPorPessoa toModel(FatorMedidoPorPessoaDTO fatorMedidoPorPessoaDTO);
	FatorMedidoPorPessoaDTO toDTO(FatorMedidoPorPessoa fatorMedidoPorPessoa);
}
