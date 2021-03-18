package com.jhemeson.msprodutividade.service;

import com.jhemeson.msprodutividade.dto.Gamificacao.LeaderboardFidelidade;
import com.jhemeson.msprodutividade.entity.MedicaoPorPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GamificacaoService {

    private MedicaoPorPessoaService medicaoPorPessoaService;

    @Autowired
    public GamificacaoService(MedicaoPorPessoaService medicaoPorPessoaService) {
        this.medicaoPorPessoaService = medicaoPorPessoaService;
    }

    public List<LeaderboardFidelidade> leaderboardFidelidade() {
        List<MedicaoPorPessoa> listMedicoes = medicaoPorPessoaService.findAll();
        List<LeaderboardFidelidade> leaderboardFidelidade = new ArrayList<>();

        listMedicoes.stream().forEach(medicaoPorPessoa -> {
            if(leaderboardFidelidade.stream().anyMatch(lf -> lf.getIdUsuario() == medicaoPorPessoa.getUsuarioId())) {
                // se já tiver na lista: altera
                LeaderboardFidelidade lfParaAtualizar = leaderboardFidelidade.stream().filter(lf -> lf.getIdUsuario() == medicaoPorPessoa.getUsuarioId()).collect(Collectors.toList()).get(0);
                lfParaAtualizar.setQuantidadeMedicoes(lfParaAtualizar.getQuantidadeMedicoes() + 1);
            } else {
                // se não tiver na lista: adiciona
                LeaderboardFidelidade novoLF = LeaderboardFidelidade.builder()
                        .idUsuario(medicaoPorPessoa.getUsuarioId())
                        .quantidadeMedicoes(1)
                        .build();
                leaderboardFidelidade.add(novoLF);
            }
        });

        return leaderboardFidelidade;
    }
}
