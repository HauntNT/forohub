package com.cesarmeza.forohub.domain.topico;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico,Long> {
    boolean existsByTituloAndMensaje(String titulo, String mensaje);

    @Query("""
            SELECT t FROM Topico t
            WHERE t.curso.nombre = :curso
            """)
    Page<Topico> buscarPorCurso(String curso, Pageable paginacion);

    @Query("""
            SELECT t FROM Topico t
            WHERE YEAR(t.fechaCreacion) = :anio
            """)
    Page<Topico> buscarPorAnio(Integer anio, Pageable paginacion);
}
