package br.com.godebts.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.config.web.servlet.SecurityMarker;

import java.time.LocalDate;

@Setter
@Getter
public class ReportDTO {

    private LocalDate data;

    private String nome;

    private String descricao;

    private double valor;

}
