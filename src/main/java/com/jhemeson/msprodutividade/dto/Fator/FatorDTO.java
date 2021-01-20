package com.jhemeson.msprodutividade.dto.Fator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FatorDTO {

	private Long id;
	private String nome;
	private String descricao;
	private String tipoDeUsuarioPreenchendo;
	private double pesoDefault;
	private String categoria;
	private String textoDoInputTextual;

}
