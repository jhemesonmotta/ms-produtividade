package com.jhemeson.msprodutividade.controller;

import com.jhemeson.msprodutividade.service.FatorService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
