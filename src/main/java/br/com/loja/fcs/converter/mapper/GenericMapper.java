package br.com.loja.fcs.converter.mapper;

import br.com.loja.fcs.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenericMapper<E, D> {

    @Autowired
    private Converter c;

    public D entityToDTO(E entity, Class<D> dto) {
        return c.converter(entity, dto);
    }

    public E dtoToEntity(D dto, Class<E> e) {
        return c.converter(dto, e);
    }

    public List<D> listEntityToDTO (List<E> objects, Class<D> dto){
        List<D> lista = new ArrayList<>();
        objects.forEach(e -> {
            lista.add(entityToDTO(e, dto));
        });

        return lista;
    }
}
