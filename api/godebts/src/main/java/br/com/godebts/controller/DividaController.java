package br.com.godebts.controller;

import br.com.godebts.dto.DividaDTO;
import br.com.godebts.dto.DividaInputDTO;
import br.com.godebts.service.DividaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/dividas")
public class DividaController {

    private DividaService dividaService;

    @PostMapping("/cadastrar/{usuarioId}")
    public DividaDTO cadastrarNovaDivida(@PathVariable Long usuarioId, @RequestBody DividaInputDTO dividaInputDTO) {
        return dividaService.cadastrarNovaDivida(dividaInputDTO, usuarioId);
    }

}
