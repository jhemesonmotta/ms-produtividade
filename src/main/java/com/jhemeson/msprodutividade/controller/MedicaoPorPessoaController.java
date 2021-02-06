package com.jhemeson.msprodutividade.controller;

import com.jhemeson.msprodutividade.dto.General.MessageResponseDTO;
import com.jhemeson.msprodutividade.dto.MedicaoPorPessoa.MedicaoPessoaComFatoresDTO;
import com.jhemeson.msprodutividade.dto.MedicaoPorPessoa.MedicaoPorPessoaDTO;
import com.jhemeson.msprodutividade.entity.MedicaoPorPessoa;
import com.jhemeson.msprodutividade.service.MedicaoPorPessoaService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicao/pessoa")
public class MedicaoPorPessoaController {

	private MedicaoPorPessoaService medicaoPorPessoaService;

	@Autowired
	public MedicaoPorPessoaController(MedicaoPorPessoaService medicaoPorPessoaService) {
		this.medicaoPorPessoaService = medicaoPorPessoaService;
	}

	@GetMapping("{id}")
	public MedicaoPorPessoaDTO buscarPorId(@PathVariable Long id) throws NotFoundException {
		return medicaoPorPessoaService.findById(id);
	}

	@GetMapping
	public List<MedicaoPorPessoa> listar() {
		return medicaoPorPessoaService.findAll();
	}

	@GetMapping("/medicao/{idMedicaoEmpresa}")
	public List<MedicaoPessoaComFatoresDTO> listarPorEmpresa(@PathVariable Long idMedicaoEmpresa) {
		return medicaoPorPessoaService.findAllByMedicaoEmpresaId(idMedicaoEmpresa);
	}

	@PostMapping
	public MessageResponseDTO adicionar(@RequestBody MedicaoPorPessoaDTO medicaoPorPessoaDTO) {
		return medicaoPorPessoaService.create(medicaoPorPessoaDTO);
	}

	@PutMapping
	public MessageResponseDTO atualizar(@RequestBody MedicaoPorPessoaDTO medicaoPorPessoaDTO) {
		return medicaoPorPessoaService.update(medicaoPorPessoaDTO);
	}
}
