package br.com.lgsreal.siscake.dto;

import java.io.File;
import java.time.LocalDate;

public record ArquivoPDFDTO(
        Long id,
        File arquivo,
        LocalDate dataUpload,
        String categoria,
        LocalDate dataEncerramento
) {
}
