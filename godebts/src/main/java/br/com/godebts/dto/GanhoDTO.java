package br.com.godebts.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class GanhoDTO {

    private Long id;

    private String nome;

    private String descricao;

    private double valor;

    private LocalDate data;

    private LocalDateTime dataHoraCadastro;


}
