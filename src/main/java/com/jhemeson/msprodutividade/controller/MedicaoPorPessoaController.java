package com.jhemeson.msprodutividade.controller;

import com.jhemeson.msprodutividade.service.MedicaoPorPessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/medicao/pessoa")
public class MedicaoPorPessoaController {

	private MedicaoPorPessoaService medicaoPorPessoaService;

	@Autowired
	public MedicaoPorPessoaController(MedicaoPorPessoaService medicaoPorPessoaService) {
		this.medicaoPorPessoaService = medicaoPorPessoaService;
	}
}
