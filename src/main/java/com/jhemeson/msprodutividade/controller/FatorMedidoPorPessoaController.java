package com.jhemeson.msprodutividade.controller;

import com.jhemeson.msprodutividade.service.FatorMedidoPorPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
