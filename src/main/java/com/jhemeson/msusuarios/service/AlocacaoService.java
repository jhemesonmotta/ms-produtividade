package com.jhemeson.msusuarios.service;

import com.jhemeson.msusuarios.dto.Alocacao.AlocacaoCompletaDTO;
import com.jhemeson.msusuarios.dto.Alocacao.AlocacaoDTO;
import com.jhemeson.msusuarios.dto.Empresa.EmpresaDTO;
import com.jhemeson.msusuarios.dto.General.MessageResponseDTO;
import com.jhemeson.msusuarios.dto.Pessoa.PessoaDTO;
import com.jhemeson.msusuarios.entity.Alocacao;
import com.jhemeson.msusuarios.mapper.AlocacaoMapper;
import com.jhemeson.msusuarios.repository.AlocacaoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlocacaoService {
    private AlocacaoRepository alocacaoRepository;
    private final AlocacaoMapper alocacaoMapper = AlocacaoMapper.INSTANCE;

    private PessoaService pessoaService;
    private EmpresaService empresaService;

    @Autowired
    public AlocacaoService(AlocacaoRepository alocacaoRepository,
                           PessoaService pessoaService, EmpresaService empresaService) {
        this.alocacaoRepository = alocacaoRepository;
        this.pessoaService = pessoaService;
        this.empresaService = empresaService;
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

    public List<AlocacaoCompletaDTO> findAlocacaosByPessoaId(Long pessoaId) {
        List<Alocacao> alocacaos = alocacaoRepository.findAlocacaosByPessoaId(pessoaId);
        List<AlocacaoCompletaDTO> alocacaoCompletaDTOS = new ArrayList<>();

        for (Alocacao a: alocacaos) {
            alocacaoCompletaDTOS.add(this.transformarParaAlocacaoCompleta(a));
        }

        return alocacaoCompletaDTOS;
    }

    public List<Alocacao> findAlocacaosByEmpresaId(Long empresaId) {
        return alocacaoRepository.findAlocacaosByEmpresaId(empresaId);
    }

    public Alocacao findAlocacaoByPessoaIdAndEmpresaId(Long pessoaId, Long empresaId) {
        return alocacaoRepository.findAlocacaoByPessoaIdAndEmpresaId(pessoaId, empresaId);
    }

    private AlocacaoCompletaDTO transformarParaAlocacaoCompleta(Alocacao alocacao) {
        AlocacaoDTO alocacaoDTO = alocacaoMapper.toDTO(alocacao);
        AlocacaoCompletaDTO alocacaoCompletaDTO = AlocacaoCompletaDTO.builder()
                .id(alocacaoDTO.getId())
                .cargo(alocacaoDTO.getCargo())
                .dataFim(alocacaoDTO.getDataFim())
                .dataInicio(alocacaoDTO.getDataInicio())
                .build();

        try {
            PessoaDTO pessoa = pessoaService.findById(alocacaoDTO.getPessoaId());
            alocacaoCompletaDTO.setPessoa(pessoa);
        } catch (Exception ex) {
            alocacaoCompletaDTO.setPessoa(
                    PessoaDTO.builder().id(alocacaoDTO.getPessoaId()).build()
            );
        }

        try {
            EmpresaDTO empresa = empresaService.findById(alocacaoDTO.getEmpresaId());
            alocacaoCompletaDTO.setEmpresa(empresa);
        } catch (Exception ex) {
            alocacaoCompletaDTO.setEmpresa(
                    EmpresaDTO.builder().id(alocacaoDTO.getEmpresaId()).build()
            );
        }

        return alocacaoCompletaDTO;
    }
}
