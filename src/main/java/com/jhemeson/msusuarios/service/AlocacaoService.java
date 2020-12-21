package com.jhemeson.msusuarios.service;

import com.jhemeson.msusuarios.dto.Alocacao.AlocacaoDTO;
import com.jhemeson.msusuarios.dto.General.MessageResponseDTO;
import com.jhemeson.msusuarios.entity.Alocacao;
import com.jhemeson.msusuarios.mapper.AlocacaoMapper;
import com.jhemeson.msusuarios.repository.AlocacaoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlocacaoService {
    private AlocacaoRepository alocacaoRepository;
    private final AlocacaoMapper alocacaoMapper = AlocacaoMapper.INSTANCE;

    @Autowired
    public AlocacaoService(AlocacaoRepository alocacaoRepository) {
        this.alocacaoRepository = alocacaoRepository;
    }

    public MessageResponseDTO create(AlocacaoDTO alocacaoDTO) {
        Alocacao alocacao = alocacaoMapper.toModel(alocacaoDTO);

        alocacao.setPessoaId(alocacaoDTO.getPessoaId());
        alocacao.setEmpresaId(alocacaoDTO.getEmpresaId());

        alocacaoRepository.save(alocacao);

        return MessageResponseDTO.builder().
                message("Alocação criada com sucesso.")
                .build();
    }

    public AlocacaoDTO findById(Long id) throws NotFoundException {
        Alocacao alocacao = alocacaoRepository.findById(id).orElseThrow(() -> new NotFoundException("Alocação não encontrada."));
        return alocacaoMapper.toDTO(alocacao);
    }

    public MessageResponseDTO update(AlocacaoDTO alocacaoDTO) {
        Alocacao alocacao = alocacaoMapper.toModel(alocacaoDTO);

        alocacao.setPessoaId(alocacaoDTO.getPessoaId());
        alocacao.setEmpresaId(alocacaoDTO.getEmpresaId());

        alocacaoRepository.save(alocacao);

        return MessageResponseDTO.builder().
                message("Alocação atualizada com sucesso.")
                .build();
    }

    public List<Alocacao> findAll() {
        return alocacaoRepository.findAll();
    }

    public List<Alocacao> findAlocacaosByPessoaId(Long pessoaId) {
        return alocacaoRepository.findAlocacaosByPessoaId(pessoaId);
    }

    public List<Alocacao> findAlocacaosByEmpresaId(Long empresaId) {
        return alocacaoRepository.findAlocacaosByEmpresaId(empresaId);
    }

    public Alocacao findAlocacaoByPessoaIdAndEmpresaId(Long pessoaId, Long empresaId) {
        return alocacaoRepository.findAlocacaoByPessoaIdAndEmpresaId(pessoaId, empresaId);
    }
}
