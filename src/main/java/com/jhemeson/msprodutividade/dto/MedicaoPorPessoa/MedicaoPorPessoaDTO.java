package com.jhemeson.msprodutividade.dto.MedicaoPorPessoa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicaoPorPessoaDTO {

	private Long id;
	private String data;
	private Long medicaoEmpresaId;
	private Long usuarioId;

}
