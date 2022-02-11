package br.com.godebts.controller;

import br.com.godebts.dto.LoginInputDTO;
import br.com.godebts.mapper.UsuarioAssembler;
import br.com.godebts.model.AuthenticationResponse;
import br.com.godebts.model.Usuario;
import br.com.godebts.repository.UsuarioRepository;
import br.com.godebts.security.ImplementsUserDetailsService;
import br.com.godebts.security.JWTUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class LoginController {

    private AuthenticationManager authenticationManager;
    private UsuarioRepository usuarioRepository;
    private UsuarioAssembler usuarioAssembler;
    private JWTUtil jwtUtil;
    private ImplementsUserDetailsService implementsUserDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginInputDTO infoLogin) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(infoLogin.getEmail(), infoLogin.getSenha()));
        } catch (BadCredentialsException ex) {
            throw new Exception("Usuario senha invalido", ex);
        }

        final UserDetails userDetails = implementsUserDetailsService.loadUserByUsername(infoLogin.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);
        Usuario usuario = usuarioRepository.findByEmail(infoLogin.getEmail());
        return ResponseEntity.ok(new AuthenticationResponse(jwt, usuarioAssembler.toModel(usuario)));
    }
}
