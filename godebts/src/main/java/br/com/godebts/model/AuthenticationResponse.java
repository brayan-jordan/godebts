package br.com.godebts.model;

import br.com.godebts.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthenticationResponse {

    private String jwt;
    private UsuarioDTO usuario;

}
