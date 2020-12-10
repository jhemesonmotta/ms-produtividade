package com.jhemeson.msusuarios.mapper;

import com.jhemeson.msusuarios.dto.Usuario.UsuarioDTO;
import com.jhemeson.msusuarios.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);
    Usuario toModel(UsuarioDTO usuarioDTO);
    UsuarioDTO toDTO(Usuario usuario);

}
