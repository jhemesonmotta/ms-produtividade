package com.jhemeson.msprodutividade.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String nome;

	@Column(nullable = false)
	private String descricao;

	@Column
	private String tipoDeUsuarioPreenchendo;

	@Column
	private double pesoDefault;

	@Column(nullable = false)
	private String categoria;

	@Column
	private String textoDoInputTextual;

	@Column
	@Builder.Default
	private Boolean ativo = true;
}
