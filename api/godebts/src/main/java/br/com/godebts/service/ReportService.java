package br.com.godebts.service;

import br.com.godebts.dto.ReportDTO;
import br.com.godebts.model.Divida;
import br.com.godebts.model.Ganho;
import br.com.godebts.model.Gasto;
import br.com.godebts.model.Usuario;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.Loader;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReportService {

    private UsuarioService usuarioService;

    public List<ReportDTO> buscarReport(Long usuarioId, LocalDate data) {
        Usuario usuario = usuarioService.buscarPeloId(usuarioId);

        List<Divida> dividasMes = usuario.getDividas().stream().filter(divida ->
                divida.getDataInicio().isBefore(data) &&
                divida.getDataFinalizacao().isAfter(data)
        ).collect(Collectors.toList());

        List<Ganho> ganhosMes = usuario.getGanhos().stream().filter(ganho ->
                ganho.getData().getMonthValue() == data.getMonthValue() &&
                ganho.getData().getYear() == data.getYear()
        ).collect(Collectors.toList());

        List<Gasto> gastosMes = usuario.getGastos().stream().filter(gasto ->
                gasto.getData().getMonthValue() == data.getMonthValue() &&
                gasto.getData().getYear() == data.getYear()
        ).collect(Collectors.toList());
    }

}
