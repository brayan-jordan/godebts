package br.com.godebts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginInputDTO {

    private String email;

    private String senha;
}
