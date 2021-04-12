package com.jhemeson.msprodutividade.controller;

import com.jhemeson.msprodutividade.dto.Gamificacao.ItemLeaderboardEmpresaDTO;
import com.jhemeson.msprodutividade.dto.Gamificacao.LeaderboardFidelidade;
import com.jhemeson.msprodutividade.entity.leaderboardEmpresas.GamAvaliacaoEmpresa;
import com.jhemeson.msprodutividade.entity.trofeus.TrofeuProdutividade;
import com.jhemeson.msprodutividade.service.GamificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/leaderboard/empresas")
    public List<ItemLeaderboardEmpresaDTO> leaderboardEmpresas() {
        return gamificacaoService.leaderboardEmpresas();
    }

    @PostMapping("/leaderboard/empresas")
    public List<GamAvaliacaoEmpresa> addLeaderboardEmpresas() {
        return gamificacaoService.registrarLeaderboardEmpresas();
    }

    @PostMapping("/trofeus/empresas")
    public List<TrofeuProdutividade> addTrofeusEmpresas() {
        return gamificacaoService.registrarTrofeus();
    }

    @GetMapping("/trofeus/empresas")
    public List<TrofeuProdutividade> trofeusEmpresas() {
        return gamificacaoService.todosTrofeus();
    }

    @GetMapping("/trofeus/empresas/{idEmpresa}")
    public List<TrofeuProdutividade> trofeusPorEmpresa(@PathVariable Long idEmpresa) {
        return gamificacaoService.trofeusPorEmpresa(idEmpresa);
    }

}
