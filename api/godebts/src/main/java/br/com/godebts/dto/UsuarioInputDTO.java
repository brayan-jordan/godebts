package br.com.godebts.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UsuarioInputDTO {

    private String nome;

    private LocalDate dataNascimento;

    private String telefone;

    private String email;

    private String senha;

}
