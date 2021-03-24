package com.jhemeson.msprodutividade.dto.MedicaoPorPessoa;

import com.jhemeson.msprodutividade.entity.FatorMedidoPorPessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicaoPessoaComFatoresDTO {

    private MedicaoPorPessoaDTO medicaoPorPessoa;
    private List<FatorMedidoPorPessoa> fatoresMedidos;

}
