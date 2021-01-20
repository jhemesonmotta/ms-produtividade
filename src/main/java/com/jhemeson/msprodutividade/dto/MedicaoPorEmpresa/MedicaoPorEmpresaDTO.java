package com.jhemeson.msprodutividade.dto.MedicaoPorEmpresa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicaoPorEmpresaDTO {

	private Long id;
	private Long criadorId;
	private Long empresaId;
	private Long configuracaoMedicaoId;
	private String dataCriacao;
	private String dataFechamento;
	private boolean status;

}
