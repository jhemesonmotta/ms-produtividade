package com.jhemeson.msprodutividade.repository;

import com.jhemeson.msprodutividade.entity.FatorMedidoPorPessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FatorMedidoPorPessoaRepository extends JpaRepository<FatorMedidoPorPessoa, Long> {
    List<FatorMedidoPorPessoa> findFatorMedidoPorPessoasByMedicaoPorPessoaId(Long medicaoPorPessoaId);
}
