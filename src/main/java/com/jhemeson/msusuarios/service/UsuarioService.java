package com.jhemeson.msusuarios.service;

import com.jhemeson.msusuarios.dto.General.MessageResponseDTO;
import com.jhemeson.msusuarios.dto.Pessoa.PessoaDTO;
import com.jhemeson.msusuarios.dto.Usuario.RequestLoginDTO;
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
                 .id(usuarioCreated.getId())
                .build();
    }

    public UsuarioCompletoDTO findById(Long id) throws NotFoundException {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuário não encontrado."));
        return transformarParaUsuarioCompleto(usuario);
    }

    public MessageResponseDTO update(UsuarioDTO usuarioDTO) {
        Usuario usuarioToUpdate = usuarioMapper.toModel(usuarioDTO);
        usuarioToUpdate.setPessoaId(usuarioDTO.getPessoaId());
        Usuario usuarioUpdated = usuarioRepository.save(usuarioToUpdate);

        return MessageResponseDTO.builder().
                message(usuarioUpdated.getEmail() + " atualizado com sucesso.")
                .id(usuarioUpdated.getId())
                .build();
    }

    public List<UsuarioCompletoDTO> findAll() throws NotFoundException {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioCompletoDTO> usuariosCompletos = new ArrayList<>();

        for (Usuario usuario: usuarios) {
            usuariosCompletos.add(transformarParaUsuarioCompleto(usuario));
        }

        return usuariosCompletos;
    }

    public UsuarioCompletoDTO logarUsuario(RequestLoginDTO requestLoginDTO) throws NotFoundException {
        Usuario usuario = usuarioRepository
                .findUsuarioByEmailAndSenha(requestLoginDTO.getEmail(), requestLoginDTO.getSenha());
        return transformarParaUsuarioCompleto(usuario);
    }

    private UsuarioCompletoDTO transformarParaUsuarioCompleto(Usuario usuario) throws NotFoundException {
        UsuarioDTO usuarioDTO = usuarioMapper.toDTO(usuario);

        try {
            PessoaDTO pessoa = pessoaService.findById(usuarioDTO.getPessoaId());

            return UsuarioCompletoDTO.builder()
                    .id(usuarioDTO.getId())
                    .email(usuarioDTO.getEmail())
                    .senha(usuarioDTO.getSenha())
                    .pessoa(pessoa)
                    .build();

        } catch (Exception ex) {

            return UsuarioCompletoDTO.builder()
                    .id(usuarioDTO.getId())
                    .email(usuarioDTO.getEmail())
                    .senha(usuarioDTO.getSenha())
                    .pessoa(PessoaDTO.builder().id(usuarioDTO.getPessoaId()).build())
                    .build();
        }
    }
}
