package com.jhemeson.msusuarios.repository;

import com.jhemeson.msusuarios.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
