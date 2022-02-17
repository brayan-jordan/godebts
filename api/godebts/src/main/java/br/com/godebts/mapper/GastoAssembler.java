package br.com.godebts.mapper;

import br.com.godebts.dto.GastoDTO;
import br.com.godebts.dto.GastoInputDTO;
import br.com.godebts.model.Gasto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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

}
