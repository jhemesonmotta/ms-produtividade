package com.jhemeson.msusuarios.controller;

import com.jhemeson.msusuarios.dto.Alocacao.AlocacaoCompletaDTO;
import com.jhemeson.msusuarios.dto.Alocacao.AlocacaoDTO;
import com.jhemeson.msusuarios.dto.General.MessageResponseDTO;
import com.jhemeson.msusuarios.entity.Alocacao;
import com.jhemeson.msusuarios.service.AlocacaoService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alocacao")
public class AlocacaoController {

    private AlocacaoService alocacaoService;

    @Autowired
    public AlocacaoController(AlocacaoService alocacaoService) {
        this.alocacaoService = alocacaoService;
    }

    @GetMapping("{id}")
    public AlocacaoDTO buscarAlocacaoPorId(@PathVariable Long id) throws NotFoundException {
        return alocacaoService.findById(id);
    }

    @GetMapping("pessoa/{pessoaId}")
    public List<AlocacaoCompletaDTO> buscarAlocacaoPorIdPessoa(@PathVariable Long pessoaId) {
        return alocacaoService.findAlocacaosByPessoaId(pessoaId);
    }

    @GetMapping("empresa/{empresaId}")
    public List<AlocacaoCompletaDTO> buscarAlocacaoPorIdEmpresa(@PathVariable Long empresaId) {
        return alocacaoService.findAlocacaosByEmpresaId(empresaId);
    }

    @GetMapping("pessoa/{pessoaId}/empresa/{empresaId}")
    public Alocacao buscarAlocacaoPorIdPessoaAndIdEmpresa(@PathVariable Long pessoaId, @PathVariable Long empresaId) {
        return alocacaoService.findAlocacaoByPessoaIdAndEmpresaId(pessoaId, empresaId);
    }

    @GetMapping
    public List<Alocacao> listarAlocacoes() {
        return alocacaoService.findAll();
    }

    @PostMapping
    public MessageResponseDTO adicionarAlocacao(@RequestBody AlocacaoDTO alocacaoDTO) {
        return alocacaoService.create(alocacaoDTO);
    }

    @PutMapping
    public MessageResponseDTO atualizarAlocacao(@RequestBody AlocacaoDTO alocacaoDTO) {
        return alocacaoService.update(alocacaoDTO);
    }
}
