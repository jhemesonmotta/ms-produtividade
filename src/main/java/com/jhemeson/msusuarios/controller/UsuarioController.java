package com.jhemeson.msusuarios.controller;

import com.jhemeson.msusuarios.dto.UsuarioDTO;
import com.jhemeson.msusuarios.service.UsuarioService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("{id}")
    public UsuarioDTO buscarUsuarioPorId(@PathVariable Long id) throws NotFoundException {
        return usuarioService.findById(id);
    }
}
