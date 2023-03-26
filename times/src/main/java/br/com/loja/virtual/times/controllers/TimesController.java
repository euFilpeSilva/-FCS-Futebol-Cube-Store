package br.com.loja.virtual.times.controllers;

import br.com.loja.virtual.times.services.TimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/times")
public class TimesController {

    @Autowired
    private TimesService timesService;
}
