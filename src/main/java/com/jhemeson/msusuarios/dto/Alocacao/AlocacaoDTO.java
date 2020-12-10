package com.jhemeson.msusuarios.dto.Alocacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlocacaoDTO {
    private Long id;
    private Long empresaId;
    private Long pessoaId;
    private String cargo;
    private String dataInicio;
    private String dataFim;
}
