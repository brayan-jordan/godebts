package br.com.godebts.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GanhoInputDTO {

    private String nome;

    private String descricao;

    private LocalDate data;

    private double valor;


}
