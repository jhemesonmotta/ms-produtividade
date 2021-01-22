package com.jhemeson.msprodutividade.controller;

import com.jhemeson.msprodutividade.service.ConfiguracaoMedicaoEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
