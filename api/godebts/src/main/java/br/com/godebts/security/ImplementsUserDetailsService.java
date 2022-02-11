package br.com.godebts.security;

import br.com.godebts.exception.NegoxioException;
import br.com.godebts.model.Usuario;
import br.com.godebts.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
@AllArgsConstructor
public class ImplementsUserDetailsService implements UserDetailsService  {

    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null){
            throw new NegoxioException("Usuario ou senha inválido");
        }
        return new User(
                usuario.getEmail(),
                usuario.getSenha(),
                true,
                true,
                true,
                true,
                usuario.getAuthorities()
        );

    }

}
