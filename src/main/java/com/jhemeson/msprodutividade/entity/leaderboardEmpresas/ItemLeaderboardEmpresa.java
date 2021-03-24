package com.jhemeson.msprodutividade.entity.leaderboardEmpresas;

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
public class ItemLeaderboardEmpresa {

    @Id
    @Column(name = "ID_LEADERBOARD")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    @Builder.Default
    private Date dtCriacao = Calendar.getInstance().getTime();

}
