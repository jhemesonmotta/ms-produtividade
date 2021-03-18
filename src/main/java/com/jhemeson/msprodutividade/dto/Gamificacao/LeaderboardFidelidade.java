package com.jhemeson.msprodutividade.dto.Gamificacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeaderboardFidelidade {
    private Long idUsuario;
    private int quantidadeMedicoes;
}
