package com.jhemeson.msprodutividade.service;

import com.jhemeson.msprodutividade.dto.Fator.FatorDTO;
import com.jhemeson.msprodutividade.dto.General.MessageResponseDTO;
import com.jhemeson.msprodutividade.entity.Fator;
import com.jhemeson.msprodutividade.mapper.FatorMapper;
import com.jhemeson.msprodutividade.repository.FatorRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FatorService {
	private FatorRepository fatorRepository;
	private final FatorMapper fatorMapper = FatorMapper.INSTANCE;

	@Autowired
	public FatorService(FatorRepository fatorRepository){
		this.fatorRepository = fatorRepository;
	}

	public MessageResponseDTO create(FatorDTO fatorDTO) {
		Fator fator = fatorMapper.toModel(fatorDTO);
		fatorRepository.save(fator);

		return MessageResponseDTO.builder().
				message("Fator criado com sucesso.")
				.build();
	}

	public FatorDTO findById(Long id) throws NotFoundException {
		Fator fator = fatorRepository.findById(id).orElseThrow(() -> new NotFoundException("Fator não encontrado."));
		return fatorMapper.toDTO(fator);
	}

	public MessageResponseDTO update(FatorDTO fatorDTO) {
		Fator fator = fatorMapper.toModel(fatorDTO);
		fatorRepository.save(fator);

		return MessageResponseDTO.builder().
				message("Fator atualizado com sucesso.")
				.build();
	}

	public List<Fator> findAll() {
		return fatorRepository.findAll();
	}
}
