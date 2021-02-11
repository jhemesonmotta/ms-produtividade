package com.jhemeson.msprodutividade.dto.FatorMedidoPorPessoa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListaFatoresDTO {

    private List<FatorMedidoPorPessoaDTO> listaFatores;

}
