package br.com.godebts.mapper;

import br.com.godebts.dto.DividaDTO;
import br.com.godebts.dto.DividaInputDTO;
import br.com.godebts.dto.ReportDTO;
import br.com.godebts.model.Divida;
import br.com.godebts.model.Gasto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DividaAssembler {

    private ModelMapper modelMapper;

    public DividaDTO toModel(Divida divida) {
        return modelMapper.map(divida, DividaDTO.class) ;
    }

    public Divida toEntity(DividaInputDTO dividaInputDTO) {
        return modelMapper.map(dividaInputDTO, Divida.class);
    }

    public ReportDTO toModelReport(Divida divida) {
        ReportDTO reportDTO = modelMapper.map(divida, ReportDTO.class);
        reportDTO.setData(divida.getDataInicio());
        return reportDTO;
    }

    public List<ReportDTO> toCollectionModelReport(List<Divida> dividas) {
        return dividas.stream().map(this::toModelReport).collect(Collectors.toList());
    }

}
