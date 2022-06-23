package br.com.godebts.controller;

import br.com.godebts.dto.LoginInputDTO;
import br.com.godebts.mapper.UsuarioAssembler;
import br.com.godebts.model.AuthenticationResponse;
import br.com.godebts.model.Usuario;
import br.com.godebts.repository.UsuarioRepository;
import br.com.godebts.security.ImplementsUserDetailsService;
import br.com.godebts.security.JWTUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController {

    private AuthenticationManager authenticationManager;
    private UsuarioRepository usuarioRepository;
    private UsuarioAssembler usuarioAssembler;
    private JWTUtil jwtUtil;
    private ImplementsUserDetailsService implementsUserDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginInputDTO infoLogin) throws Exception {
        Usuario usuario = usuarioAssembler.toEntityLogin(infoLogin);
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new Exception("Usuario senha invalido", ex);
        }

        final UserDetails userDetails = implementsUserDetailsService.loadUserByUsername(usuario.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        Usuario usuarioCarregado = usuarioRepository.findByEmail(usuario.getEmail());
        return ResponseEntity.ok(new AuthenticationResponse(jwt, usuarioAssembler.toModel(usuarioCarregado)));
    }
}
