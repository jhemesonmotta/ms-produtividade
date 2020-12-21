package com.jhemeson.msusuarios.repository;

import com.jhemeson.msusuarios.entity.Alocacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlocacaoRepository extends JpaRepository<Alocacao, Long>  {
    List<Alocacao> findAlocacaosByPessoaId(Long pessoaId);

    List<Alocacao> findAlocacaosByEmpresaId(Long empresaID);

    Alocacao findAlocacaoByPessoaIdAndEmpresaId(Long pessoaId, Long empresaID);
}
