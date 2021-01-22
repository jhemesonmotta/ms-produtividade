package com.jhemeson.msprodutividade.controller;

import com.jhemeson.msprodutividade.dto.Fator.FatorDTO;
import com.jhemeson.msprodutividade.service.FatorService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
