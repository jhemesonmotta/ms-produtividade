package com.jhemeson.msprodutividade.controller;

import com.jhemeson.msprodutividade.dto.FatorMedidoPorPessoa.FatorMedidoPorPessoaDTO;
import com.jhemeson.msprodutividade.service.FatorMedidoPorPessoaService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fator/pessoa")
public class FatorMedidoPorPessoaController {

	private FatorMedidoPorPessoaService fatorMedidoPorPessoaService;

	@Autowired
	public FatorMedidoPorPessoaController(FatorMedidoPorPessoaService fatorMedidoPorPessoaService) {
		this.fatorMedidoPorPessoaService = fatorMedidoPorPessoaService;
	}

	@GetMapping("{id}")
	public FatorMedidoPorPessoaDTO buscarPorId(@PathVariable Long id) throws NotFoundException {
		return fatorMedidoPorPessoaService.findById(id);
	}
}
