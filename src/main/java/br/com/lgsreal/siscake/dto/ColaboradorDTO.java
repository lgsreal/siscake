package br.com.lgsreal.siscake.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ColaboradorDTO(
        Long id,
        @NotBlank(message = "O nome não pode estar em branco")
        String nome,
        String email,
        @NotBlank(message = "A data de nascimento é obrigatória")
        LocalDate dataNascimento,
        String departamento,
        int contadorOfertaBolos
) {
}
