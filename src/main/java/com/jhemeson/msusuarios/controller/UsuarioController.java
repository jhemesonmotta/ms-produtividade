package com.jhemeson.msusuarios.controller;

import com.jhemeson.msusuarios.dto.General.MessageResponseDTO;
import com.jhemeson.msusuarios.dto.Usuario.UsuarioCompletoDTO;
import com.jhemeson.msusuarios.dto.Usuario.UsuarioDTO;
import com.jhemeson.msusuarios.entity.Usuario;
import com.jhemeson.msusuarios.service.UsuarioService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("{id}")
    public UsuarioCompletoDTO buscarUsuarioPorId(@PathVariable Long id) throws NotFoundException {
        return usuarioService.findById(id);
    }

    @GetMapping
    public List<UsuarioCompletoDTO> listarUsuarios() throws NotFoundException {
        return usuarioService.findAll();
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
