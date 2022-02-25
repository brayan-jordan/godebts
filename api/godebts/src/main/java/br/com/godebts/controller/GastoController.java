package br.com.godebts.controller;

import br.com.godebts.dto.GastoDTO;
import br.com.godebts.dto.GastoInputDTO;
import br.com.godebts.service.GastoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gastos")
@AllArgsConstructor
public class GastoController {

    private GastoService gastoService;

    @PostMapping("/adicionar/{usuarioId}")
    public GastoDTO cadastrarGasto(@RequestBody GastoInputDTO infoGasto, @PathVariable Long usuarioId) {
        return gastoService.adicionarGasto(infoGasto, usuarioId);
    }

    @PostMapping("/duplicar/{usuarioId}/{gastoId}")
    public GastoDTO adicionarGastoProxMes(@PathVariable Long usuarioId, @PathVariable Long gastoId) {
        return gastoService.duplicarGastoProxMes(usuarioId, gastoId);
    }

    @DeleteMapping("/deletar/{gastoId}")
    public void deletarGasto(@PathVariable Long gastoId) {
        gastoService.deletarGasto(gastoId);
    }

}
