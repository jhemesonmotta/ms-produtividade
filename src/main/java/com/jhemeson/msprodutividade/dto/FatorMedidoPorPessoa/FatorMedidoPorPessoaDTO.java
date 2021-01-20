package com.jhemeson.msprodutividade.dto.FatorMedidoPorPessoa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FatorMedidoPorPessoaDTO {

	private Long id;
	private Long fatorId;
	private Long medicaoPorPessoaId;
	private double nota;
	private String comentarios;

}
