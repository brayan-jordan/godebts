package br.com.godebts.controller;

import br.com.godebts.dto.DataInputDTO;
import br.com.godebts.dto.ReportDTO;
import br.com.godebts.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class ReportController {

    private ReportService reportService;

    @GetMapping("/report/{usuarioId}")
    public List<ReportDTO> listarReport(@PathVariable Long usuarioId, @RequestBody DataInputDTO data) {
        return reportService.buscarReport(usuarioId, data.getData());
    }

}
