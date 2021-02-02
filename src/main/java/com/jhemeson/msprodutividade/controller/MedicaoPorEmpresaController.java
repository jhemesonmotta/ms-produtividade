package com.jhemeson.msprodutividade.controller;

import com.jhemeson.msprodutividade.dto.General.MessageResponseDTO;
import com.jhemeson.msprodutividade.dto.MedicaoPorEmpresa.MedicaoPorEmpresaDTO;
import com.jhemeson.msprodutividade.entity.MedicaoPorEmpresa;
import com.jhemeson.msprodutividade.service.MedicaoPorEmpresaService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicao/empresa")
public class MedicaoPorEmpresaController {

	private MedicaoPorEmpresaService medicaoPorEmpresaService;

	@Autowired
	public MedicaoPorEmpresaController(MedicaoPorEmpresaService medicaoPorEmpresaService) {
		this.medicaoPorEmpresaService = medicaoPorEmpresaService;
	}

	@GetMapping("{id}")
	public MedicaoPorEmpresaDTO buscarPorId(@PathVariable Long id) throws NotFoundException {
		return medicaoPorEmpresaService.findById(id);
	}

	@GetMapping
	public List<MedicaoPorEmpresa> listar() {
		return medicaoPorEmpresaService.findAll();
	}

	@PostMapping
	public MessageResponseDTO adicionar(@RequestBody MedicaoPorEmpresaDTO medicaoPorEmpresaDTO) {
		return medicaoPorEmpresaService.create(medicaoPorEmpresaDTO);
	}

	@PutMapping
	public MessageResponseDTO atualizar(@RequestBody MedicaoPorEmpresaDTO medicaoPorEmpresaDTO) {
		return medicaoPorEmpresaService.update(medicaoPorEmpresaDTO);
	}

}
