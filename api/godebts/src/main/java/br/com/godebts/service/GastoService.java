package br.com.godebts.service;

import br.com.godebts.dto.GastoDTO;
import br.com.godebts.dto.GastoInputDTO;
import br.com.godebts.mapper.GastoAssembler;
import br.com.godebts.model.Gasto;
import br.com.godebts.repository.GastoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class GastoService {

    private GastoRepository gastoRepository;
    private GastoAssembler gastoAssembler;
    private UsuarioService usuarioService;

    public GastoDTO adicionarGasto(GastoInputDTO infoGasto, Long usuarioId) {
        Gasto gasto = gastoAssembler.toEntity(infoGasto);
        gasto.setUsuario(usuarioService.buscarPeloId(usuarioId));
        gasto.setValor(gasto.getValor() - gasto.getValor() * 2);
        gasto.setDataHoraCadastro(LocalDateTime.now());

        return gastoAssembler.toModel(gastoRepository.save(gasto));
    }

}
