package com.jhemeson.msprodutividade.entity.trofeus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrofeuProdutividade {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int posicaoPodio;

    @Column(nullable = false, name = "empresa_id")
    private Long empresaId;

    @Column(nullable = false, name = "desc_trofeu")
    private String descricao;

    @Column(name = "dt_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    @Builder.Default
    private Date dtCriacao = Calendar.getInstance().getTime();
}
