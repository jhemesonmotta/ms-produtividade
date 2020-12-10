package com.jhemeson.msusuarios.controller;

import com.jhemeson.msusuarios.dto.General.MessageResponseDTO;
import com.jhemeson.msusuarios.dto.Pessoa.PessoaDTO;
import com.jhemeson.msusuarios.entity.Pessoa;
import com.jhemeson.msusuarios.service.PessoaService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaController {

    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("{id}")
    public PessoaDTO buscarPessoaPorId(@PathVariable Long id) throws NotFoundException {
        return pessoaService.findById(id);
    }

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaService.findAll();
    }

    @PostMapping
    public MessageResponseDTO adicionarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.create(pessoaDTO);
    }

    @PutMapping
    public MessageResponseDTO atualizarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.update(pessoaDTO);
    }
}
