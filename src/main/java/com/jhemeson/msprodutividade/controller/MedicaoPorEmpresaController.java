package com.jhemeson.msprodutividade.controller;

import com.jhemeson.msprodutividade.service.MedicaoPorEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/medicao/empresa")
public class MedicaoPorEmpresaController {

	private MedicaoPorEmpresaService medicaoPorEmpresaService;

	@Autowired
	public MedicaoPorEmpresaController(MedicaoPorEmpresaService medicaoPorEmpresaService) {
		this.medicaoPorEmpresaService = medicaoPorEmpresaService;
	}
}
