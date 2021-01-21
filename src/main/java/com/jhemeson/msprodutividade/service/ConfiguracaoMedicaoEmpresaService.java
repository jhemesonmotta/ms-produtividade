package com.jhemeson.msprodutividade.service;

import com.jhemeson.msprodutividade.dto.ConfiguracaoMedicaoEmpresa.ConfiguracaoMedicaoEmpresaDTO;
import com.jhemeson.msprodutividade.dto.General.MessageResponseDTO;
import com.jhemeson.msprodutividade.entity.ConfiguracaoMedicaoEmpresa;
import com.jhemeson.msprodutividade.mapper.ConfiguracaoMedicaoEmpresaMapper;
import com.jhemeson.msprodutividade.repository.ConfiguracaoMedicaoEmpresaRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfiguracaoMedicaoEmpresaService {
	private ConfiguracaoMedicaoEmpresaRepository configuracaoMedicaoEmpresaRepository;
	private final ConfiguracaoMedicaoEmpresaMapper configuracaoMedicaoEmpresaMapper = ConfiguracaoMedicaoEmpresaMapper.INSTANCE;

	@Autowired
	public ConfiguracaoMedicaoEmpresaService(ConfiguracaoMedicaoEmpresaRepository configuracaoMedicaoEmpresaRepository){
		this.configuracaoMedicaoEmpresaRepository = configuracaoMedicaoEmpresaRepository;
	}

	public MessageResponseDTO create(ConfiguracaoMedicaoEmpresaDTO configuracaoMedicaoEmpresaDTO) {
		ConfiguracaoMedicaoEmpresa configuracaoMedicaoEmpresa = configuracaoMedicaoEmpresaMapper.toModel(configuracaoMedicaoEmpresaDTO);
		configuracaoMedicaoEmpresaRepository.save(configuracaoMedicaoEmpresa);

		return MessageResponseDTO.builder().
				message("Configuração criada com sucesso.")
				.build();
	}

	public ConfiguracaoMedicaoEmpresaDTO findById(Long id) throws NotFoundException {
		ConfiguracaoMedicaoEmpresa configuracaoMedicaoEmpresa = configuracaoMedicaoEmpresaRepository.findById(id).orElseThrow(() -> new NotFoundException("Configuração não encontrada."));
		return configuracaoMedicaoEmpresaMapper.toDTO(configuracaoMedicaoEmpresa);
	}

	public MessageResponseDTO update(ConfiguracaoMedicaoEmpresaDTO configuracaoMedicaoEmpresaDTO) {
		ConfiguracaoMedicaoEmpresa configuracaoMedicaoEmpresa = configuracaoMedicaoEmpresaMapper.toModel(configuracaoMedicaoEmpresaDTO);
		configuracaoMedicaoEmpresaRepository.save(configuracaoMedicaoEmpresa);

		return MessageResponseDTO.builder().
				message("Configuração atualizada com sucesso.")
				.build();
	}

	public List<ConfiguracaoMedicaoEmpresa> findAll() {
		return configuracaoMedicaoEmpresaRepository.findAll();
	}
}
