package br.com.godebts.mapper;

import br.com.godebts.dto.GastoDTO;
import br.com.godebts.dto.GastoInputDTO;
import br.com.godebts.dto.ReportDTO;
import br.com.godebts.model.Gasto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GastoAssembler {

    private ModelMapper modelMapper;

    public GastoDTO toModel(Gasto gasto) {
        return modelMapper.map(gasto, GastoDTO.class);
    }

    public Gasto toEntity(GastoInputDTO gastoInputDTO) {
        return modelMapper.map(gastoInputDTO, Gasto.class);
    }

    public ReportDTO toModelReport(Gasto gasto) {
        return modelMapper.map(gasto, ReportDTO.class);
    }

    public List<ReportDTO> toCollectionModelReport(List<Gasto> gastos) {
        return gastos.stream().map(this::toModelReport).collect(Collectors.toList());
    }
}
