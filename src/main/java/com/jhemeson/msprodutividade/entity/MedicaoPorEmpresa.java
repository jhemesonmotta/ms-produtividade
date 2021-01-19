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
public class MedicaoPorEmpresa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, name = "criador_id")
	private Long criadorId;

	@Column(nullable = false, name = "empresa_id")
	private Long empresaId;

	@Column(nullable = false, name = "configuracao_medicao_id")
	private Long configuracaoMedicaoId;

	@Column(name = "data_criacao", nullable = false)
	private String dataCriacao;

	@Column(name = "data_fechamento")
	private String dataFechamento;

	@Column
	private boolean status;
}
