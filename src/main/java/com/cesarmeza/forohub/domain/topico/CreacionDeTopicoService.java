package com.cesarmeza.forohub.domain.topico;

import com.cesarmeza.forohub.domain.ValidacionException;
import com.cesarmeza.forohub.domain.curso.Curso;
import com.cesarmeza.forohub.domain.curso.CursoRepository;
import com.cesarmeza.forohub.domain.usuario.Usuario;
import com.cesarmeza.forohub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreacionDeTopicoService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public DatosDetalleTopico crear(DatosCrearTopico datos){
        if (!cursoRepository.existsById(datos.idCurso())){
            throw new ValidacionException("No existe un curso para asignar el topico.");
        }
        if (topicoRepository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())){
            throw new ValidacionException("Ya existe un topico con el mismo titulo y mensaje.");
        }
        Usuario usuario = (Usuario) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        Curso curso = cursoRepository.getReferenceById(datos.idCurso());

        Topico topico = new Topico(null, datos.titulo(), datos.mensaje(), LocalDateTime.now(), Status.VIGENTE, usuario, curso);
        topicoRepository.save(topico);
        return new DatosDetalleTopico(topico);
    }
}
