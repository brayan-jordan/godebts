package br.com.godebts.controller;

import br.com.godebts.dto.UsuarioDTO;
import br.com.godebts.dto.UsuarioInputDTO;
import br.com.godebts.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public UsuarioDTO cadastrarUsuario(@RequestBody UsuarioInputDTO usuarioInputDTO) {
        return usuarioService.cadastrarUsuario(usuarioInputDTO);
    }

}
