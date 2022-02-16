package br.com.godebts.service;

import br.com.godebts.dto.UsuarioDTO;
import br.com.godebts.dto.UsuarioInputDTO;
import br.com.godebts.exception.NegoxioException;
import br.com.godebts.mapper.UsuarioAssembler;
import br.com.godebts.model.Role;
import br.com.godebts.model.Usuario;
import br.com.godebts.repository.RoleRepository;
import br.com.godebts.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioAssembler usuarioAssembler;
    private RoleRepository roleRepository;

    public UsuarioDTO cadastrarUsuario(UsuarioInputDTO usuarioInput) {
        if (usuarioRepository.existsByEmail(usuarioInput.getEmail()).isPresent()) {
            throw new NegoxioException("Já existe um usuário com esse email");
        }

        Usuario usuarioToSave = usuarioAssembler.toEntity(usuarioInput);
        List<Role> allRoles = roleRepository.findAll();
        usuarioToSave.setDataHoraCadastro(LocalDateTime.now());
        usuarioToSave.setSenha(new BCryptPasswordEncoder().encode(usuarioToSave.getSenha()));
        usuarioToSave.setRoles(allRoles);
        return usuarioAssembler.toModel(usuarioRepository.save(usuarioToSave));
    }

}
