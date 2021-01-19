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
public class MedicaoPorPessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String data;

	@Column(nullable = false, name = "medicao_empresa_id")
	private Long medicaoEmpresaId;

	@Column(nullable = false, name = "usuario_id")
	private Long usuarioId;
}