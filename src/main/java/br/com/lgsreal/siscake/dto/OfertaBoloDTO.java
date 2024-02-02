package br.com.lgsreal.siscake.dto;

import java.time.LocalDate;

public record OfertaBoloDTO(
        Long id,
        Long colaboradorId,
        int quantidadeBolos,
        LocalDate dataOferta
) {
}
