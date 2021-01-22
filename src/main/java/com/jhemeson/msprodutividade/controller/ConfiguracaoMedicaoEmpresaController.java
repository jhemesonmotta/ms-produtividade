package com.jhemeson.msprodutividade.controller;

import com.jhemeson.msprodutividade.dto.ConfiguracaoMedicaoEmpresa.ConfiguracaoMedicaoEmpresaDTO;
import com.jhemeson.msprodutividade.dto.General.MessageResponseDTO;
import com.jhemeson.msprodutividade.entity.ConfiguracaoMedicaoEmpresa;
import com.jhemeson.msprodutividade.service.ConfiguracaoMedicaoEmpresaService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

	@GetMapping
	public List<ConfiguracaoMedicaoEmpresa> listar() {
		return configuracaoMedicaoEmpresaService.findAll();
	}

	@PostMapping
	public MessageResponseDTO adicionar(@RequestBody ConfiguracaoMedicaoEmpresaDTO configuracaoMedicaoEmpresaDTO) {
		return configuracaoMedicaoEmpresaService.create(configuracaoMedicaoEmpresaDTO);
	}

	@PutMapping
	public MessageResponseDTO atualizar(@RequestBody ConfiguracaoMedicaoEmpresaDTO configuracaoMedicaoEmpresaDTO) {
		return configuracaoMedicaoEmpresaService.update(configuracaoMedicaoEmpresaDTO);
	}
}
