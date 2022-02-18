package br.com.godebts.controller;

import br.com.godebts.dto.GanhoDTO;
import br.com.godebts.dto.GanhoInputDTO;
import br.com.godebts.service.GanhoService;
import lombok.AllArgsConstructor;
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

}
