package com.jhemeson.msusuarios.dto;

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
    private EmpresaDTO empresa;
    private PessoaDTO pessoa;
    private String cargo;
    private String dataInicio;
    private String dataFim;
}
