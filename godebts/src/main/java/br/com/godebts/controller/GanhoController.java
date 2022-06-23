package br.com.godebts.controller;

import br.com.godebts.dto.GanhoDTO;
import br.com.godebts.dto.GanhoInputDTO;
import br.com.godebts.service.GanhoService;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.Loader;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ganhos")
@AllArgsConstructor
public class GanhoController {

    private GanhoService ganhoService;

    @PostMapping("/adicionar/{usuarioId}")
    public GanhoDTO adicionarNovoGanho(@RequestBody GanhoInputDTO infoGanho, @PathVariable Long usuarioId) {
        return ganhoService.adicionarNovoGanho(infoGanho, usuarioId);
    }

    @PostMapping("/duplicar/{usuarioId}/{ganhoId}")
    public GanhoDTO duplicarGanho(@PathVariable Long usuarioId, @PathVariable Long ganhoId) {
        return ganhoService.duplicarGastoProxMes(usuarioId, ganhoId);
    }

    @DeleteMapping("/deletar/{ganhoId}")
    public void  deletarGanho(@PathVariable Long ganhoId) {
        ganhoService.deletarGanho(ganhoId);
    }

    @PatchMapping("/editar/{ganhoId}")
    public GanhoDTO editarGanho(@PathVariable Long ganhoId, @RequestBody GanhoInputDTO ganhoInputDTO) {
        return ganhoService.editarGanho(ganhoId, ganhoInputDTO);
    }
}
