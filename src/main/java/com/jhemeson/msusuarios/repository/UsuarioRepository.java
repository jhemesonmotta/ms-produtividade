package com.jhemeson.msusuarios.repository;

import com.jhemeson.msusuarios.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
