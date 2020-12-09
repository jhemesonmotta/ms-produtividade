package com.jhemeson.msusuarios.repository;

import com.jhemeson.msusuarios.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
