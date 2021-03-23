package com.jhemeson.msprodutividade.repository;

import com.jhemeson.msprodutividade.entity.leaderboardEmpresas.ItemLeaderboardEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaderboardEmpresaRepository extends JpaRepository<ItemLeaderboardEmpresa, Long> {

}
