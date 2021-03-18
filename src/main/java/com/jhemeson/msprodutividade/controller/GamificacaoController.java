package com.jhemeson.msprodutividade.controller;

import com.jhemeson.msprodutividade.dto.Gamificacao.LeaderboardFidelidade;
import com.jhemeson.msprodutividade.service.GamificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<LeaderboardFidelidade> listar() {
        return gamificacaoService.leaderboardFidelidade();
    }
}
