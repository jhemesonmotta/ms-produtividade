package com.jhemeson.msprodutividade.service;

import com.jhemeson.msprodutividade.dto.General.MessageResponseDTO;
import com.jhemeson.msprodutividade.dto.MedicaoPorEmpresa.MedicaoPorEmpresaDTO;
import com.jhemeson.msprodutividade.entity.MedicaoPorEmpresa;
import com.jhemeson.msprodutividade.mapper.MedicaoPorEmpresaMapper;
import com.jhemeson.msprodutividade.repository.MedicaoPorEmpresaRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicaoPorEmpresaService {
	private MedicaoPorEmpresaRepository medicaoPorEmpresaRepository;
	private final MedicaoPorEmpresaMapper medicaoPorEmpresaMapper = MedicaoPorEmpresaMapper.INSTANCE;

	@Autowired
	public MedicaoPorEmpresaService(MedicaoPorEmpresaRepository medicaoPorEmpresaRepository){
		this.medicaoPorEmpresaRepository = medicaoPorEmpresaRepository;
	}

	public MessageResponseDTO create(MedicaoPorEmpresaDTO medicaoPorEmpresaDTO) {
		MedicaoPorEmpresa medicaoPorEmpresa = medicaoPorEmpresaMapper.toModel(medicaoPorEmpresaDTO);
		medicaoPorEmpresaRepository.save(medicaoPorEmpresa);

		return MessageResponseDTO.builder().
				message("Medição criada com sucesso.")
				.build();
	}

	public MedicaoPorEmpresaDTO findById(Long id) throws NotFoundException {
		MedicaoPorEmpresa medicaoPorEmpresa = medicaoPorEmpresaRepository.findById(id).orElseThrow(() -> new NotFoundException("Medição não encontrada."));
		return medicaoPorEmpresaMapper.toDTO(medicaoPorEmpresa);
	}

	public MessageResponseDTO update(MedicaoPorEmpresaDTO medicaoPorEmpresaDTO) {
		MedicaoPorEmpresa medicaoPorEmpresa = medicaoPorEmpresaMapper.toModel(medicaoPorEmpresaDTO);
		medicaoPorEmpresaRepository.save(medicaoPorEmpresa);

		return MessageResponseDTO.builder().
				message("Medição atualizada com sucesso.")
				.build();
	}

	public List<MedicaoPorEmpresa> findAll() {
		return medicaoPorEmpresaRepository.findAll();
	}
}
