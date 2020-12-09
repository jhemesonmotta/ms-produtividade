package com.jhemeson.msusuarios.service;

import com.jhemeson.msusuarios.dto.MessageResponseDTO;
import com.jhemeson.msusuarios.dto.UsuarioDTO;
import com.jhemeson.msusuarios.entity.Projeto;
import com.jhemeson.msusuarios.entity.Usuario;
import com.jhemeson.msusuarios.mapper.UsuarioMapper;
import com.jhemeson.msusuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public MessageResponseDTO create(UsuarioDTO usuarioDTO) {
        Usuario usuarioToCreate = usuarioMapper.toModel(usuarioDTO);
        Usuario usuarioCreated = usuarioRepository.save(usuarioToCreate);

         return MessageResponseDTO.builder().
                message(usuarioCreated.getEmail() + " criado com sucesso.")
                .build();
    }
}
