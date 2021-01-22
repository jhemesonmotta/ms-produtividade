package com.jhemeson.msprodutividade.controller;

import com.jhemeson.msprodutividade.dto.Fator.FatorDTO;
import com.jhemeson.msprodutividade.dto.General.MessageResponseDTO;
import com.jhemeson.msprodutividade.entity.Fator;
import com.jhemeson.msprodutividade.service.FatorService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fator")
public class FatorController {

	private FatorService fatorService;

	@Autowired
	public FatorController(FatorService fatorService) {
		this.fatorService = fatorService;
	}

	@GetMapping("{id}")
	public FatorDTO buscarPorId(@PathVariable Long id) throws NotFoundException {
		return fatorService.findById(id);
	}

	@GetMapping
	public List<Fator> listar() {
		return fatorService.findAll();
	}

	@PostMapping
	public MessageResponseDTO adicionar(@RequestBody FatorDTO fatorDTO) {
		return fatorService.create(fatorDTO);
	}

	@PutMapping
	public MessageResponseDTO atualizar(@RequestBody FatorDTO fatorDTO) {
		return fatorService.update(fatorDTO);
	}
}
