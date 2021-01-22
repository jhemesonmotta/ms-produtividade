package com.jhemeson.msprodutividade.service;

import com.jhemeson.msprodutividade.dto.FatorMedidoPorPessoa.FatorMedidoPorPessoaDTO;
import com.jhemeson.msprodutividade.dto.General.MessageResponseDTO;
import com.jhemeson.msprodutividade.entity.FatorMedidoPorPessoa;
import com.jhemeson.msprodutividade.mapper.FatorMedidoPorPessoaMapper;
import com.jhemeson.msprodutividade.repository.FatorMedidoPorPessoaRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FatorMedidoPorPessoaService {
	private FatorMedidoPorPessoaRepository fatorMedidoPorPessoaRepository;
	private final FatorMedidoPorPessoaMapper fatorMedidoPorPessoaMapper = FatorMedidoPorPessoaMapper.INSTANCE;

	@Autowired
	public FatorMedidoPorPessoaService(FatorMedidoPorPessoaRepository fatorMedidoPorPessoaRepository){
		this.fatorMedidoPorPessoaRepository = fatorMedidoPorPessoaRepository;
	}

	public MessageResponseDTO create(FatorMedidoPorPessoaDTO fatorMedidoPorPessoaDTO) {
		FatorMedidoPorPessoa fator = fatorMedidoPorPessoaMapper.toModel(fatorMedidoPorPessoaDTO);
		FatorMedidoPorPessoa fatorCriado = fatorMedidoPorPessoaRepository.save(fator);

		return MessageResponseDTO.builder()
				.id(fatorCriado.getId())
				.message("Fator medido com sucesso.")
				.build();
	}

	public FatorMedidoPorPessoaDTO findById(Long id) throws NotFoundException {
		FatorMedidoPorPessoa fatorMedidoPorPessoa = fatorMedidoPorPessoaRepository.findById(id).orElseThrow(() -> new NotFoundException("Fator não encontrado."));
		return fatorMedidoPorPessoaMapper.toDTO(fatorMedidoPorPessoa);
	}

	public MessageResponseDTO update(FatorMedidoPorPessoaDTO fatorMedidoPorPessoaDTO) {
		FatorMedidoPorPessoa fator = fatorMedidoPorPessoaMapper.toModel(fatorMedidoPorPessoaDTO);
		fatorMedidoPorPessoaRepository.save(fator);

		return MessageResponseDTO.builder().
				message("Fator atualizado com sucesso.")
				.build();
	}

	public List<FatorMedidoPorPessoa> findAll() {
		return fatorMedidoPorPessoaRepository.findAll();
	}
}
