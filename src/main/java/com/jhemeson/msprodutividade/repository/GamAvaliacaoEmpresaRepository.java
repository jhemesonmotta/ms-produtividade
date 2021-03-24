package com.jhemeson.msprodutividade.repository;

import com.jhemeson.msprodutividade.entity.leaderboardEmpresas.GamAvaliacaoEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GamAvaliacaoEmpresaRepository extends JpaRepository<GamAvaliacaoEmpresa, Long> {
    List<GamAvaliacaoEmpresa> findGamAvaliacaoEmpresasByLeaderboardId(Long leaderboardId);
}
