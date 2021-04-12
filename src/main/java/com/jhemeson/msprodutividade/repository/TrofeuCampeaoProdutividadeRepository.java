package com.jhemeson.msprodutividade.repository;

import com.jhemeson.msprodutividade.entity.trofeus.TrofeuProdutividade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrofeuCampeaoProdutividadeRepository extends JpaRepository<TrofeuProdutividade, Long> {

}
