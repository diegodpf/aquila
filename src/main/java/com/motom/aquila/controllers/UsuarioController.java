package com.motom.aquila.controllers;

import com.motom.aquila.services.contracts.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @RequestMapping("/")
    public ModelAndView criar() {
        return new ModelAndView("index")
                .addObject("usuario", service.buscarPorId(1L));
    }

}
