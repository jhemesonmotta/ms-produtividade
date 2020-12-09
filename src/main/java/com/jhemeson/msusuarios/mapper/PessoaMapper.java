package com.jhemeson.msusuarios.mapper;

import com.jhemeson.msusuarios.dto.PessoaDTO;
import com.jhemeson.msusuarios.entity.Pessoa;
import org.mapstruct.factory.Mappers;

public interface PessoaMapper {
    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);
    Pessoa toModel(PessoaDTO pessoaDTO);
    PessoaDTO toDTO(Pessoa pessoa);
}
