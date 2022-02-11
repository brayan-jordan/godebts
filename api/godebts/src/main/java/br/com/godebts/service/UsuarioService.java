package br.com.godebts.service;

import br.com.godebts.mapper.UsuarioAssembler;
import br.com.godebts.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioAssembler usuarioAssembler;

}
