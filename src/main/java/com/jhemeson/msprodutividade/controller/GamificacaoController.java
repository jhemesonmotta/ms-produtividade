package com.jhemeson.msprodutividade.controller;

import com.jhemeson.msprodutividade.dto.Gamificacao.ItemLeaderboardEmpresaDTO;
import com.jhemeson.msprodutividade.dto.Gamificacao.LeaderboardFidelidade;
import com.jhemeson.msprodutividade.entity.leaderboardEmpresas.ItemLeaderboardEmpresa;
import com.jhemeson.msprodutividade.service.GamificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gamificacao")
public class GamificacaoController {

    private GamificacaoService gamificacaoService;

    @Autowired
    public GamificacaoController(GamificacaoService gamificacaoService) {
        this.gamificacaoService = gamificacaoService;
    }

    @GetMapping("/leaderboard/fidelidade")
    public List<LeaderboardFidelidade> leaderboardFidelidade() {
        return gamificacaoService.leaderboardFidelidade();
    }

    @PostMapping("/leaderboard/empresas")
    public List<LeaderboardFidelidade> addLeaderboardEmpresas() {
        gamificacaoService.registrarLeaderboardEmpresas();
        return gamificacaoService.leaderboardFidelidade();
    }

    @GetMapping("/leaderboard/empresas")
    public List<ItemLeaderboardEmpresaDTO> leaderboardEmpresas() {
        return gamificacaoService.leaderboardEmpresas();
    }
}
