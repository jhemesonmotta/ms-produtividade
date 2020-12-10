package com.jhemeson.msusuarios.service;

import com.jhemeson.msusuarios.dto.MessageResponseDTO;
import com.jhemeson.msusuarios.dto.UsuarioDTO;
import com.jhemeson.msusuarios.entity.Usuario;
import com.jhemeson.msusuarios.mapper.UsuarioMapper;
import com.jhemeson.msusuarios.repository.UsuarioRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public UsuarioDTO findById(Long id) throws NotFoundException {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuário não encontrado."));
        return usuarioMapper.toDTO(usuario);
    }

    public MessageResponseDTO update(UsuarioDTO usuarioDTO) {
        Usuario usuarioToUpdate = usuarioMapper.toModel(usuarioDTO);
        Usuario usuarioUpdated = usuarioRepository.save(usuarioToUpdate);

        return MessageResponseDTO.builder().
                message(usuarioUpdated.getEmail() + " atualizado com sucesso.")
                .build();
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    // TODO: login de usuário > findUserByEmail

}
