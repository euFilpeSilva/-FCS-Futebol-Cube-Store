package br.com.loja.fcs.services;

import br.com.loja.fcs.domain.repository.TimesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimesService {

    @Autowired
    private TimesRepository timesRepository;
}
