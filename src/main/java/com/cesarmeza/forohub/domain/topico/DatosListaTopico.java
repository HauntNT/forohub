package com.cesarmeza.forohub.domain.topico;

import com.cesarmeza.forohub.domain.curso.Curso;
import com.cesarmeza.forohub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosListaTopico(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Status status,
        String usuario,
        String curso
) {
    public DatosListaTopico(Topico topico){
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getUsuario().getNombre(),
                topico.getCurso().getNombre()
        );
    }
}
