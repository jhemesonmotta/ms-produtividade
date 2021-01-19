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
public class ConfiguracaoMedicaoEmpresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false, name = "empresa_id")
	private Long empresaId;

	@Column(name = "data_criacao")
	private String dataCriacao;
}

