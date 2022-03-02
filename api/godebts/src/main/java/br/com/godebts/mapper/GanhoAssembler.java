package br.com.godebts.mapper;

import br.com.godebts.dto.GanhoDTO;
import br.com.godebts.dto.GanhoInputDTO;
import br.com.godebts.dto.ReportDTO;
import br.com.godebts.model.Ganho;
import br.com.godebts.model.Gasto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class GanhoAssembler {

    private ModelMapper modelMapper;

    public GanhoDTO toModel(Ganho ganho) {
        return modelMapper.map(ganho, GanhoDTO.class);
    }

    public Ganho toEntity(GanhoInputDTO ganhoInputDTO) {
        return modelMapper.map(ganhoInputDTO, Ganho.class);
    }

    public ReportDTO toModelReport(Ganho ganho) {
        return modelMapper.map(ganho, ReportDTO.class);
    }

    public List<ReportDTO> toCollectionModelReport(List<Ganho> ganhos) {
        return ganhos.stream().map(this::toModelReport).collect(Collectors.toList());
    }

}
