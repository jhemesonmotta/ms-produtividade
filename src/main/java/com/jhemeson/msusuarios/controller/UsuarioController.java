package com.jhemeson.msusuarios.controller;

import com.jhemeson.msusuarios.dto.MessageResponseDTO;
import com.jhemeson.msusuarios.dto.UsuarioDTO;
import com.jhemeson.msusuarios.service.UsuarioService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public MessageResponseDTO adicionarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.create(usuarioDTO);
    }

    @PutMapping
    public MessageResponseDTO atualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.update(usuarioDTO);
    }

}
