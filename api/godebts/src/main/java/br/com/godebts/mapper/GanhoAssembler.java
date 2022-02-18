package br.com.godebts.mapper;

import br.com.godebts.dto.GanhoDTO;
import br.com.godebts.dto.GanhoInputDTO;
import br.com.godebts.model.Ganho;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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

}
