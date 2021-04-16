package com.jhemeson.msprodutividade.service;

import com.jhemeson.msprodutividade.dto.Gamificacao.ItemLeaderboardEmpresaDTO;
import com.jhemeson.msprodutividade.dto.Gamificacao.LeaderboardFidelidade;
import com.jhemeson.msprodutividade.entity.MedicaoPorEmpresa;
import com.jhemeson.msprodutividade.entity.MedicaoPorPessoa;
import com.jhemeson.msprodutividade.entity.leaderboardEmpresas.GamAvaliacaoEmpresa;
import com.jhemeson.msprodutividade.entity.leaderboardEmpresas.ItemLeaderboardEmpresa;
import com.jhemeson.msprodutividade.entity.trofeus.TrofeuProdutividade;
import com.jhemeson.msprodutividade.repository.GamAvaliacaoEmpresaRepository;
import com.jhemeson.msprodutividade.repository.LeaderboardEmpresaRepository;
import com.jhemeson.msprodutividade.repository.TrofeuCampeaoProdutividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GamificacaoService {

    private MedicaoPorPessoaService medicaoPorPessoaService;
    private MedicaoPorEmpresaService medicaoPorEmpresaService;

    private LeaderboardEmpresaRepository leaderboardEmpresaRepository;
    private GamAvaliacaoEmpresaRepository gamAvaliacaoEmpresaRepository;
    private TrofeuCampeaoProdutividadeRepository trofeuRepository;

    @Autowired
    public GamificacaoService(MedicaoPorPessoaService medicaoPorPessoaService,
                              LeaderboardEmpresaRepository leaderboardEmpresaRepository,
                              MedicaoPorEmpresaService medicaoPorEmpresaService,
                              GamAvaliacaoEmpresaRepository gamAvaliacaoEmpresaRepository,
                              TrofeuCampeaoProdutividadeRepository trofeuRepository) {
        this.medicaoPorPessoaService = medicaoPorPessoaService;
        this.leaderboardEmpresaRepository = leaderboardEmpresaRepository;
        this.medicaoPorEmpresaService = medicaoPorEmpresaService;
        this.gamAvaliacaoEmpresaRepository = gamAvaliacaoEmpresaRepository;
        this.trofeuRepository = trofeuRepository;
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

    public List<ItemLeaderboardEmpresaDTO> leaderboardEmpresas() {
        List<ItemLeaderboardEmpresa> leaderboardModel = leaderboardEmpresaRepository.findAll();

        List<ItemLeaderboardEmpresaDTO> leaderboard = leaderboardModel.stream().map(item -> ItemLeaderboardEmpresaDTO
                .builder()
                .id(item.getId())
                .dtCriacao(item.getDtCriacao())
                .avaliacoes(gamAvaliacaoEmpresaRepository.findGamAvaliacaoEmpresasByLeaderboardId(item.getId()))
        .build()).collect(Collectors.toList());

        return leaderboard;
    }

    public List<GamAvaliacaoEmpresa> registrarLeaderboardEmpresas() {
        List<MedicaoPorEmpresa> todasMedicoes = medicaoPorEmpresaService.findAll();
        todasMedicoes = todasMedicoes.stream()
                .filter(m -> {
                    try {
                        if (m.getNotaFechada() != null && m.getNotaFechada() > 0 && m.getDataFechamento() != null) {
                            Date dataFechamento = new SimpleDateFormat("dd/MM/yyyy").parse(m.getDataFechamento());
                            Date umMesAtras = new Date();
                            umMesAtras.setMonth(umMesAtras.getMonth()-1);

                            if (dataFechamento.after(umMesAtras)) {
                                return true;
                            }
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .collect(Collectors.toList());

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

        return avaliacoesPorEmpresa;
    }

    public List<TrofeuProdutividade> registrarTrofeus() {
        List<ItemLeaderboardEmpresaDTO> leaderboardList = leaderboardEmpresas();
        List<TrofeuProdutividade> trofeusList = new ArrayList<>();

        if (!leaderboardList.isEmpty()) {
            ItemLeaderboardEmpresaDTO leaderboardItem = leaderboardList.get(leaderboardList.size()-1);
            List<GamAvaliacaoEmpresa> avaliacoes = leaderboardItem.getAvaliacoes();

            if (!avaliacoes.isEmpty()) {
                Collections.sort(avaliacoes);
                Collections.reverse(avaliacoes);
                avaliacoes = avaliacoes.stream().limit(3).collect(Collectors.toList());

                int pos = 1;

                for (GamAvaliacaoEmpresa a: avaliacoes) {

                    TrofeuProdutividade t = TrofeuProdutividade.builder()
                            .posicaoPodio(pos)
                            .empresaId(a.getEmpresaId())
                            .descricao("Troféu Produtividade")
                            .build();

                    trofeusList.add(trofeuRepository.save(t));
                    pos = pos + 1;
                }

                return trofeusList;
            }
        }

        return null;
    }

    public List<TrofeuProdutividade> todosTrofeus() {
        return trofeuRepository.findAll();
    }

    public List<TrofeuProdutividade> trofeusPorEmpresa(Long empresaId) {
        return trofeuRepository
                .findAll()
                .stream()
                .filter(e -> e.getEmpresaId() == empresaId)
                .collect(Collectors.toList());
    }
}
