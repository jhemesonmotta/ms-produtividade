package com.jhemeson.msusuarios.controller;

import com.jhemeson.msusuarios.dto.MessageResponseDTO;
import com.jhemeson.msusuarios.dto.PessoaDTO;
import com.jhemeson.msusuarios.dto.UsuarioDTO;
import com.jhemeson.msusuarios.service.PessoaService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public MessageResponseDTO adicionarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.create(pessoaDTO);
    }

    @PutMapping
    public MessageResponseDTO atualizarPessoa(@RequestBody PessoaDTO pessoaDTO) {
        return pessoaService.update(pessoaDTO);
    }
}
