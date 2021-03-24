package com.jhemeson.msprodutividade.dto.Gamificacao;

import com.jhemeson.msprodutividade.entity.leaderboardEmpresas.GamAvaliacaoEmpresa;
import com.jhemeson.msprodutividade.entity.leaderboardEmpresas.ItemLeaderboardEmpresa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemLeaderboardEmpresaDTO {
    private Long id;
    private Date dtCriacao;
    private List<GamAvaliacaoEmpresa> avaliacoes;
}
