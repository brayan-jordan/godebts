package br.com.godebts.mapper;

import br.com.godebts.dto.LoginInputDTO;
import br.com.godebts.dto.UsuarioDTO;
import br.com.godebts.dto.UsuarioInputDTO;
import br.com.godebts.model.Usuario;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UsuarioAssembler {

    private ModelMapper modelMapper;

    public Usuario toEntity(UsuarioInputDTO usuarioInputDTO) {
        return modelMapper.map(usuarioInputDTO, Usuario.class);
    }

    public UsuarioDTO toModel(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    public Usuario toEntityLogin(LoginInputDTO loginInputDTO) {
        return modelMapper.map(loginInputDTO, Usuario.class);
    }

}
