package com.jhemeson.msprodutividade.service;

import com.jhemeson.msprodutividade.dto.General.MessageResponseDTO;
import com.jhemeson.msprodutividade.dto.MedicaoPorPessoa.MedicaoPorPessoaDTO;
import com.jhemeson.msprodutividade.entity.MedicaoPorPessoa;
import com.jhemeson.msprodutividade.mapper.MedicaoPorPessoaMapper;
import com.jhemeson.msprodutividade.repository.MedicaoPorPessoaRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicaoPorPessoaService {
	private MedicaoPorPessoaRepository medicaoPorPessoaRepository;
	private final MedicaoPorPessoaMapper medicaoPorPessoaMapper = MedicaoPorPessoaMapper.INSTANCE;

	@Autowired
	public MedicaoPorPessoaService(MedicaoPorPessoaRepository medicaoPorPessoaRepository){
		this.medicaoPorPessoaRepository = medicaoPorPessoaRepository;
	}

	public MessageResponseDTO create(MedicaoPorPessoaDTO medicaoPorPessoaDTO) {
		MedicaoPorPessoa medicaoPorPessoa = medicaoPorPessoaMapper.toModel(medicaoPorPessoaDTO);
		medicaoPorPessoaRepository.save(medicaoPorPessoa);

		return MessageResponseDTO.builder().
				message("Medição criada com sucesso.")
				.build();
	}

	public MedicaoPorPessoaDTO findById(Long id) throws NotFoundException {
		MedicaoPorPessoa medicaoPorPessoa = medicaoPorPessoaRepository.findById(id).orElseThrow(() -> new NotFoundException("Fator não encontrado."));
		return medicaoPorPessoaMapper.toDTO(medicaoPorPessoa);
	}

	public MessageResponseDTO update(MedicaoPorPessoaDTO medicaoPorPessoaDTO) {
		MedicaoPorPessoa medicaoPorPessoa = medicaoPorPessoaMapper.toModel(medicaoPorPessoaDTO);
		medicaoPorPessoaRepository.save(medicaoPorPessoa);


		return MessageResponseDTO.builder().
				message("Medição atualizada com sucesso.")
				.build();
	}

	public List<MedicaoPorPessoa> findAll() {
		return medicaoPorPessoaRepository.findAll();
	}
}
