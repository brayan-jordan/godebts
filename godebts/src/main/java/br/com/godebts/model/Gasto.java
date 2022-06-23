package br.com.godebts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gastos")
public class Gasto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @NotNull
    private double valor;

    @NotNull
    private String nome;

    @NotNull
    private String descricao;

    @NotNull
    private LocalDate data;

    private LocalDateTime dataHoraCadastro;
}
