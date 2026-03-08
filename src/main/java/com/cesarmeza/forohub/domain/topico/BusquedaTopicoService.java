package com.cesarmeza.forohub.domain.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BusquedaTopicoService {

    @Autowired
    private TopicoRepository repository;

    public Page<DatosListaTopico> buscar(String curso, Integer anio, Pageable paginacion){

        if(curso != null && anio == null){
            return repository.buscarPorCurso(curso, paginacion)
                    .map(DatosListaTopico::new);
        }

        if(curso == null && anio != null){
            return repository.buscarPorAnio(anio, paginacion)
                    .map(DatosListaTopico::new);
        }

        return repository.findAll(paginacion)
                .map(DatosListaTopico::new);
    }
}
