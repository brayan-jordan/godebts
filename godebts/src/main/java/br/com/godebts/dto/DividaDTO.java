package br.com.godebts.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DividaDTO {

    private Long id;

    private String nome;

    private String descricao;

    private double valor;

    private LocalDate dataInicio;

    private LocalDate finalizacao;



}
