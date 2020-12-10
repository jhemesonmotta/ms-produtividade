package com.jhemeson.msusuarios.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Alocacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "empresa_id")
    private Long empresaId;

    @Column(name = "pessoa_id")
    private Long pessoaId;

    @Column
    private String cargo;

    @Column(name = "data_inicio")
    private String dataInicio;

    @Column(name = "data_fim")
    private String dataFim;
}
