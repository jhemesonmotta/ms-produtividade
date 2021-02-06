package com.jhemeson.msprodutividade.mapper;

import com.jhemeson.msprodutividade.dto.MedicaoPorPessoa.MedicaoPessoaComFatoresDTO;
import com.jhemeson.msprodutividade.dto.MedicaoPorPessoa.MedicaoPorPessoaDTO;
import com.jhemeson.msprodutividade.entity.MedicaoPorPessoa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicaoPorPessoaMapper {
	MedicaoPorPessoaMapper INSTANCE = Mappers.getMapper(MedicaoPorPessoaMapper.class);
	MedicaoPorPessoa toModel(MedicaoPorPessoaDTO medicaoPorPessoaDTO);
	MedicaoPorPessoaDTO toDTO(MedicaoPorPessoa medicaoPorPessoa);
}
