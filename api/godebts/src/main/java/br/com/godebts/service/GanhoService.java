package br.com.godebts.service;

import br.com.godebts.dto.GanhoDTO;
import br.com.godebts.dto.GanhoInputDTO;
import br.com.godebts.dto.GastoDTO;
import br.com.godebts.exception.NegoxioException;
import br.com.godebts.mapper.GanhoAssembler;
import br.com.godebts.model.Ganho;
import br.com.godebts.model.Gasto;
import br.com.godebts.repository.GanhoRepository;
import br.com.godebts.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class GanhoService {

    private GanhoRepository ganhoRepository;
    private GanhoAssembler ganhoAssembler;
    private UsuarioService usuarioService;

    public GanhoDTO adicionarNovoGanho(GanhoInputDTO ganhoInputDTO, Long usuarioId) {
        Ganho ganho = ganhoAssembler.toEntity(ganhoInputDTO);
        ganho.setUsuario(usuarioService.buscarPeloId(usuarioId));
        ganho.setDataHoraCadastro(LocalDateTime.now());

        return ganhoAssembler.toModel(ganhoRepository.save(ganho));
    }

    public GanhoDTO duplicarGastoProxMes(Long usuarioId, Long ganhoId) {
        Ganho ganho = ganhoRepository.findById(ganhoId).orElseThrow(() -> new NegoxioException(
                "Teste"
        ));

        Ganho novoGanho = new Ganho();
        novoGanho.setValor(ganho.getValor());
        novoGanho.setUsuario(ganho.getUsuario());
        novoGanho.setDescricao(ganho.getDescricao());
        novoGanho.setNome(ganho.getNome());
        novoGanho.setData(ganho.getData().plusMonths(1));
        novoGanho.setDataHoraCadastro(LocalDateTime.now());
        return ganhoAssembler.toModel(ganhoRepository.save(novoGanho));
    }

}
