package com.jhemeson.msusuarios.mapper;

import com.jhemeson.msusuarios.dto.Pessoa.PessoaDTO;
import com.jhemeson.msusuarios.entity.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PessoaMapper {
    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);
    Pessoa toModel(PessoaDTO pessoaDTO);
    PessoaDTO toDTO(Pessoa pessoa);
}
