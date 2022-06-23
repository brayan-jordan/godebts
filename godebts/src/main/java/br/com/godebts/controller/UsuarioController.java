package br.com.godebts.controller;

import br.com.godebts.dto.UsuarioDTO;
import br.com.godebts.dto.UsuarioInputDTO;
import br.com.godebts.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public UsuarioDTO cadastrarUsuario(@RequestBody UsuarioInputDTO usuarioInputDTO) {
        return usuarioService.cadastrarUsuario(usuarioInputDTO);
    }

    @GetMapping("/buscar/{usuarioId}")
    public UsuarioDTO buscarUsuario(@PathVariable Long usuarioId) {
        return usuarioService.buscarUsuario(usuarioId);
    }

}
