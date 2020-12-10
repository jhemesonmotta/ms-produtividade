package com.jhemeson.msusuarios.service;

import com.jhemeson.msusuarios.dto.General.MessageResponseDTO;
import com.jhemeson.msusuarios.dto.Usuario.UsuarioCompletoDTO;
import com.jhemeson.msusuarios.dto.Usuario.UsuarioDTO;
import com.jhemeson.msusuarios.entity.Usuario;
import com.jhemeson.msusuarios.mapper.UsuarioMapper;
import com.jhemeson.msusuarios.repository.UsuarioRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private PessoaService pessoaService;

    private final UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PessoaService pessoaService) {
        this.usuarioRepository = usuarioRepository;
        this.pessoaService = pessoaService;
    }

    public MessageResponseDTO create(UsuarioDTO usuarioDTO) {
        Usuario usuarioToCreate = usuarioMapper.toModel(usuarioDTO);
        usuarioToCreate.setPessoaId(usuarioDTO.getPessoaId());
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

    public List<UsuarioCompletoDTO> findAll() throws NotFoundException {
        // UsuarioCompletoDTO
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioCompletoDTO> usuariosCompletos = new ArrayList<>();

        for (Usuario usuario: usuarios) {
            usuariosCompletos.add(transformarParaUsuarioCompleto(usuario));
        }

        return usuariosCompletos;
    }

    private UsuarioCompletoDTO transformarParaUsuarioCompleto(Usuario usuario) throws NotFoundException {
        UsuarioDTO usuarioDTO = usuarioMapper.toDTO(usuario);

        return UsuarioCompletoDTO.builder()
                .id(usuarioDTO.getId())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha())
                .pessoa(pessoaService.findById(usuarioDTO.getId()))
                .build();
    }

    // TODO: login de usuário > findUserByEmail

}
