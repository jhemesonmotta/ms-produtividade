package com.jhemeson.msusuarios.service;

import com.jhemeson.msusuarios.dto.General.MessageResponseDTO;
import com.jhemeson.msusuarios.dto.Pessoa.PessoaDTO;
import com.jhemeson.msusuarios.entity.Pessoa;
import com.jhemeson.msusuarios.mapper.PessoaMapper;
import com.jhemeson.msusuarios.repository.PessoaRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public MessageResponseDTO create(PessoaDTO pessoaDTO) {
        Pessoa pessoaToCreate = pessoaMapper.toModel(pessoaDTO);
        Pessoa pessoaCreated = pessoaRepository.save(pessoaToCreate);

        return MessageResponseDTO.builder()
                .message(pessoaCreated.getNome() + " criado com sucesso.")
                .id(pessoaCreated.getId())
                .build();
    }

    public PessoaDTO findById(Long id) throws NotFoundException {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuário não encontrado."));
        return pessoaMapper.toDTO(pessoa);
    }

    public MessageResponseDTO update(PessoaDTO pessoaDTO) {
        Pessoa pessoaToUpdate = pessoaMapper.toModel(pessoaDTO);
        Pessoa pessoaUpdated = pessoaRepository.save(pessoaToUpdate);

        return MessageResponseDTO.builder()
                .message(pessoaUpdated.getNome() + " atualizado com sucesso.")
                .id(pessoaUpdated.getId())
                .build();
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }
}
