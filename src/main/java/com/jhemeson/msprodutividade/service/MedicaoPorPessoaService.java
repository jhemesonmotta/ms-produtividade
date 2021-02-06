package com.jhemeson.msprodutividade.service;

import com.jhemeson.msprodutividade.dto.General.MessageResponseDTO;
import com.jhemeson.msprodutividade.dto.MedicaoPorPessoa.MedicaoPessoaComFatoresDTO;
import com.jhemeson.msprodutividade.dto.MedicaoPorPessoa.MedicaoPorPessoaDTO;
import com.jhemeson.msprodutividade.entity.FatorMedidoPorPessoa;
import com.jhemeson.msprodutividade.entity.MedicaoPorPessoa;
import com.jhemeson.msprodutividade.mapper.MedicaoPorPessoaMapper;
import com.jhemeson.msprodutividade.repository.MedicaoPorPessoaRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicaoPorPessoaService {
	private MedicaoPorPessoaRepository medicaoPorPessoaRepository;
	private FatorMedidoPorPessoaService fatorMedidoPorPessoaService;

	private final MedicaoPorPessoaMapper medicaoPorPessoaMapper = MedicaoPorPessoaMapper.INSTANCE;

	@Autowired
	public MedicaoPorPessoaService(MedicaoPorPessoaRepository medicaoPorPessoaRepository, FatorMedidoPorPessoaService fatorMedidoPorPessoaService){
		this.medicaoPorPessoaRepository = medicaoPorPessoaRepository;
		this.fatorMedidoPorPessoaService = fatorMedidoPorPessoaService;
	}

	public MessageResponseDTO create(MedicaoPorPessoaDTO medicaoPorPessoaDTO) {
		MedicaoPorPessoa medicaoPorPessoa = medicaoPorPessoaMapper.toModel(medicaoPorPessoaDTO);
		MedicaoPorPessoa medicaoCriada = medicaoPorPessoaRepository.save(medicaoPorPessoa);

		return MessageResponseDTO.builder()
				.id(medicaoCriada.getId())
				.message("Medição criada com sucesso.")
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

	public List<MedicaoPessoaComFatoresDTO> findAllByMedicaoEmpresaId(Long medicaoEmpresaId) {
		List<MedicaoPorPessoa> medicaoPorPessoaList = medicaoPorPessoaRepository.findMedicaoPorPessoasByMedicaoEmpresaId(medicaoEmpresaId);
		List<MedicaoPessoaComFatoresDTO> medicaoPessoaComFatoresDTOList = new ArrayList<>();

		for (MedicaoPorPessoa mp: medicaoPorPessoaList) {
			MedicaoPorPessoaDTO medicaoPorPessoaDTO = medicaoPorPessoaMapper.toDTO(mp);
			List<FatorMedidoPorPessoa> fatoresMedidos = fatorMedidoPorPessoaService.findAllByMedicaoId(mp.getId());

			MedicaoPessoaComFatoresDTO medicaoPessoaComFatoresDTO = MedicaoPessoaComFatoresDTO.builder()
					.medicaoPorPessoa(medicaoPorPessoaDTO)
					.fatoresMedidos(fatoresMedidos)
					.build();
			medicaoPessoaComFatoresDTOList.add(medicaoPessoaComFatoresDTO);
		}

		return medicaoPessoaComFatoresDTOList;
	}

}
