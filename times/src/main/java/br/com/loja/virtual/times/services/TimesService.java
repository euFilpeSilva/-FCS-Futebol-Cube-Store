package br.com.loja.virtual.times.services;

import br.com.loja.virtual.times.domain.repository.TimesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimesService {

    @Autowired
    private TimesRepository timesRepository;
}
