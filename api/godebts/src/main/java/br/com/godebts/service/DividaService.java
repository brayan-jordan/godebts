package br.com.godebts.service;

import br.com.godebts.dto.DividaDTO;
import br.com.godebts.dto.DividaInputDTO;
import br.com.godebts.mapper.DividaAssembler;
import br.com.godebts.model.Divida;
import br.com.godebts.model.Usuario;
import br.com.godebts.repository.DividaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class DividaService {

    private DividaRepository dividaRepository;
    private UsuarioService usuarioService;
    private DividaAssembler dividaAssembler;

    public DividaDTO cadastrarNovaDivida(DividaInputDTO dividaInputDTO, Long usuarioId) {
        Usuario usuario = usuarioService.buscarPeloId(usuarioId);

        Divida divida = dividaAssembler.toEntity(dividaInputDTO);
        divida.setUsuario(usuario);
        divida.setDataHoraCadastro(LocalDateTime.now());
        return dividaAssembler.toModel(dividaRepository.save(divida));
    }

}
