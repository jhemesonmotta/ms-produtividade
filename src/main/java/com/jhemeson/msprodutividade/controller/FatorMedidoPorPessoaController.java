package com.jhemeson.msprodutividade.controller;

import com.jhemeson.msprodutividade.dto.FatorMedidoPorPessoa.FatorMedidoPorPessoaDTO;
import com.jhemeson.msprodutividade.dto.FatorMedidoPorPessoa.ListaFatoresDTO;
import com.jhemeson.msprodutividade.dto.General.MessageResponseDTO;
import com.jhemeson.msprodutividade.entity.FatorMedidoPorPessoa;
import com.jhemeson.msprodutividade.service.FatorMedidoPorPessoaService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fator/pessoa")
public class FatorMedidoPorPessoaController {

	private FatorMedidoPorPessoaService fatorMedidoPorPessoaService;

	@Autowired
	public FatorMedidoPorPessoaController(FatorMedidoPorPessoaService fatorMedidoPorPessoaService) {
		this.fatorMedidoPorPessoaService = fatorMedidoPorPessoaService;
	}

	@GetMapping("{id}")
	public FatorMedidoPorPessoaDTO buscarPorId(@PathVariable Long id) throws NotFoundException {
		return fatorMedidoPorPessoaService.findById(id);
	}

	@GetMapping
	public List<FatorMedidoPorPessoa> listar() {
		return fatorMedidoPorPessoaService.findAll();
	}

	@GetMapping("medicao/{medicaoId}")
	public List<FatorMedidoPorPessoa> listarPorMedicao(@PathVariable Long medicaoId) {
		return fatorMedidoPorPessoaService.findAllByMedicaoId(medicaoId);
	}

	@PostMapping
	public MessageResponseDTO adicionar(@RequestBody FatorMedidoPorPessoaDTO fatorMedidoPorPessoaDTO) {
		return fatorMedidoPorPessoaService.create(fatorMedidoPorPessoaDTO);
	}

	@PostMapping("/lista")
	public List<MessageResponseDTO> adicionarLista(@RequestBody ListaFatoresDTO listaFatoresDTO) {
		List<MessageResponseDTO> retornos = new ArrayList<>();

		for (FatorMedidoPorPessoaDTO fmpt: listaFatoresDTO.getListaFatores()) {
			MessageResponseDTO retorno = fatorMedidoPorPessoaService.create(fmpt);
			retornos.add(retorno);
		}

		return retornos;
	}

	@PutMapping
	public MessageResponseDTO atualizar(@RequestBody FatorMedidoPorPessoaDTO fatorMedidoPorPessoaDTO) {
		return fatorMedidoPorPessoaService.update(fatorMedidoPorPessoaDTO);
	}
}
