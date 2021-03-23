package com.jhemeson.msprodutividade.service;

import com.jhemeson.msprodutividade.dto.Gamificacao.LeaderboardFidelidade;
import com.jhemeson.msprodutividade.entity.MedicaoPorEmpresa;
import com.jhemeson.msprodutividade.entity.MedicaoPorPessoa;
import com.jhemeson.msprodutividade.entity.leaderboardEmpresas.GamAvaliacaoEmpresa;
import com.jhemeson.msprodutividade.entity.leaderboardEmpresas.ItemLeaderboardEmpresa;
import com.jhemeson.msprodutividade.repository.GamAvaliacaoEmpresaRepository;
import com.jhemeson.msprodutividade.repository.LeaderboardEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GamificacaoService {

    private MedicaoPorPessoaService medicaoPorPessoaService;
    private MedicaoPorEmpresaService medicaoPorEmpresaService;
    private LeaderboardEmpresaRepository leaderboardEmpresaRepository;
    private GamAvaliacaoEmpresaRepository gamAvaliacaoEmpresaRepository;

    @Autowired
    public GamificacaoService(MedicaoPorPessoaService medicaoPorPessoaService,
                              LeaderboardEmpresaRepository leaderboardEmpresaRepository,
                              MedicaoPorEmpresaService medicaoPorEmpresaService,
                              GamAvaliacaoEmpresaRepository gamAvaliacaoEmpresaRepository) {
        this.medicaoPorPessoaService = medicaoPorPessoaService;
        this.leaderboardEmpresaRepository = leaderboardEmpresaRepository;
        this.medicaoPorEmpresaService = medicaoPorEmpresaService;
        this.gamAvaliacaoEmpresaRepository = gamAvaliacaoEmpresaRepository;
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

    public List<ItemLeaderboardEmpresa> leaderboardEmpresas() {
        // TODO: criar um DTO e buscar os GamAvaliacaoEmpresa por leaderboard.
        return leaderboardEmpresaRepository.findAll();
    }

    public void registrarLeaderboardEmpresas() {
        List<MedicaoPorEmpresa> todasMedicoes = medicaoPorEmpresaService.findAll();
        todasMedicoes = todasMedicoes.stream().filter(m -> m.getNotaFechada() != null && m.getNotaFechada() > 0).collect(Collectors.toList());

        // TODO: pegar só medições fechadas no ultimo mes

        List<GamAvaliacaoEmpresa> avaliacoesPorEmpresa = new ArrayList<>();
        List<GamAvaliacaoEmpresa> avaliacoesPorEmpresaSalvas = new ArrayList<>();

        todasMedicoes.stream().forEach(medicaoPorEmpresa -> {
            if (avaliacoesPorEmpresa.stream().anyMatch(gae -> gae.getEmpresaId() == medicaoPorEmpresa.getEmpresaId())) {
                // se já existir: atualiza
                GamAvaliacaoEmpresa avalEmpresa = avaliacoesPorEmpresa.stream().filter(ae -> ae.getEmpresaId() == medicaoPorEmpresa.getEmpresaId()).collect(Collectors.toList()).get(0);
                avalEmpresa.setMediaAvaliacao((avalEmpresa.getMediaAvaliacao() + medicaoPorEmpresa.getNotaFechada())/2);
            } else {
                // se não: adiciona
                GamAvaliacaoEmpresa novoItem = GamAvaliacaoEmpresa
                        .builder()
                        .leaderboardId(0L)
                        .empresaId(medicaoPorEmpresa.getEmpresaId())
                        .mediaAvaliacao(medicaoPorEmpresa.getNotaFechada())
                        .build();
                avaliacoesPorEmpresa.add(novoItem);
            }
        });

        ItemLeaderboardEmpresa itemLeaderboardSalvo = leaderboardEmpresaRepository.save(ItemLeaderboardEmpresa.builder().build());

        ItemLeaderboardEmpresa finalItemLeaderboardSalvo = itemLeaderboardSalvo;

        avaliacoesPorEmpresa.forEach(ae -> {
            ae.setLeaderboardId(finalItemLeaderboardSalvo.getId());
            avaliacoesPorEmpresaSalvas.add(gamAvaliacaoEmpresaRepository.save(ae));
        });

        String teste = "teste";
    }

}
