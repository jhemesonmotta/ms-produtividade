package com.jhemeson.msusuarios.dto.Usuario;

import com.jhemeson.msusuarios.dto.Pessoa.PessoaDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCompletoDTO {
    private Long id;
    private String email;
    private String senha;
    private PessoaDTO pessoa;
}
