package com.jhemeson.msprodutividade.controller;

import com.jhemeson.msprodutividade.dto.ConfiguracaoMedicaoEmpresa.ConfiguracaoMedicaoEmpresaDTO;
import com.jhemeson.msprodutividade.service.ConfiguracaoMedicaoEmpresaService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/configuracao")
public class ConfiguracaoMedicaoEmpresaController {

	private ConfiguracaoMedicaoEmpresaService configuracaoMedicaoEmpresaService;

	@Autowired
	public ConfiguracaoMedicaoEmpresaController(ConfiguracaoMedicaoEmpresaService configuracaoMedicaoEmpresaService) {
		this.configuracaoMedicaoEmpresaService = configuracaoMedicaoEmpresaService;
	}

	@GetMapping("{id}")
	public ConfiguracaoMedicaoEmpresaDTO buscarPorId(@PathVariable Long id) throws NotFoundException {
		return configuracaoMedicaoEmpresaService.findById(id);
	}
}
