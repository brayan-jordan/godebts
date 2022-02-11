package br.com.godebts.service;

import br.com.godebts.dto.UsuarioDTO;
import br.com.godebts.dto.UsuarioInputDTO;
import br.com.godebts.exception.NegoxioException;
import br.com.godebts.mapper.UsuarioAssembler;
import br.com.godebts.model.Usuario;
import br.com.godebts.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioAssembler usuarioAssembler;

    private UsuarioDTO cadastrarUsuario(UsuarioInputDTO usuarioInput) {
        if (usuarioRepository.existsByEmail(usuarioInput.getEmail()).isPresent()) {
            throw new NegoxioException("Já existe um usuário com esse email");
        }

        Usuario usuarioToSave = usuarioAssembler.toEntity(usuarioInput);
        usuarioToSave.setDataHoraCadastro(LocalDateTime.now());
        return usuarioAssembler.toModel(usuarioRepository.save(usuarioToSave));

    }

}
