package com.cesarmeza.forohub.domain.topico;

import com.cesarmeza.forohub.domain.curso.Curso;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosActualizacionTopico(
        String titulo,
        String mensaje,
        Status status
) {
}
