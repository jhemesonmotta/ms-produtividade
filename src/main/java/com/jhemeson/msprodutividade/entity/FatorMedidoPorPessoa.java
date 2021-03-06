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
public class FatorMedidoPorPessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, name = "fator_id")
	private Long fatorId;

	@Column(nullable = false, name = "medicao_pessoa_id")
	private Long medicaoPorPessoaId;

	@Column(nullable = false)
	private double nota;

	@Column(nullable = false)
	private String comentarios;
}
