package com.jhemeson.msprodutividade.entity.leaderboardEmpresas;

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
public class GamAvaliacaoEmpresa implements Comparable<GamAvaliacaoEmpresa> {

    @Id
    @Column(name = "ID_MEDICAO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "leaderboard_id")
    private Long leaderboardId;

    @Column(nullable = false, name = "empresa_id")
    private Long empresaId;

    @Column(name = "media_avaliacao")
    private Double mediaAvaliacao;

    @Override
    public int compareTo(GamAvaliacaoEmpresa u) {
        if (getMediaAvaliacao() == null || u.getMediaAvaliacao() == null) {
            return 0;
        }
        return getMediaAvaliacao().compareTo(u.getMediaAvaliacao());
    }
}
