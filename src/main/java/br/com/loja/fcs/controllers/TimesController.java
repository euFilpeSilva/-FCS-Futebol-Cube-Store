package br.com.loja.fcs.controllers;

import br.com.loja.fcs.services.TimesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/times")
@Api(tags = "Times API", description = "Endpoints para gerenciamento de times")
public class TimesController {

    @Autowired
    private TimesService timesService;
}
