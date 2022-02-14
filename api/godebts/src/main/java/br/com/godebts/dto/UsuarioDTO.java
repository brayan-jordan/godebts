package br.com.godebts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private String telefone;

    private String email;

    private LocalDateTime dataHoraCadastro;

}
