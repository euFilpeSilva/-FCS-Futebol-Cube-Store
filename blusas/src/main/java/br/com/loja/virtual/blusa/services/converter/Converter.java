package br.com.loja.virtual.blusa.services.converter;

import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

@Service
public class Converter {

    private static final ModelMapper MAPPER = new ModelMapper();
    private static final org.modelmapper.Converter INSTANCE = new org.modelmapper.Converter() {
        @Override
        public Object convert(MappingContext context) {
            return null;
        }
    };

    private Converter() {
        super();
    }

    public static org.modelmapper.Converter getInstance() {
        return INSTANCE;
    }

    public static <S, T> T converter(S source, Class<T> target) {
        return MAPPER.map(source, target);
    }

    public <S, T> T converter(S source, Class<T> target, PropertyMap<S, T> propertyMap) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(propertyMap);
        return modelMapper.map(source, target);
    }
}
