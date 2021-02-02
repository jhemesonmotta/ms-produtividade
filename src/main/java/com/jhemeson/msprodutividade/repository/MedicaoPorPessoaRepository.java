package com.jhemeson.msprodutividade.repository;

import com.jhemeson.msprodutividade.entity.MedicaoPorPessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicaoPorPessoaRepository extends JpaRepository<MedicaoPorPessoa, Long> {

    List<MedicaoPorPessoa> findMedicaoPorPessoasByMedicaoEmpresaId(Long medicaoEmpresaId);

}
