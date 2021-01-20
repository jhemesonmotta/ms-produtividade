package com.jhemeson.msprodutividade.dto.ConfiguracaoMedicaoEmpresa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfiguracaoMedicaoEmpresaDTO {

	private Long id;
	private Long empresaId;
	private String dataCriacao;

}
