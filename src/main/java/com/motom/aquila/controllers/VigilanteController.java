package com.motom.aquila.controllers;

import com.motom.aquila.models.Localizacao;
import com.motom.aquila.models.Vigilante;
import com.motom.aquila.services.contracts.VigilanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VigilanteController {

    @Autowired
    private VigilanteService service;

    private List<Localizacao> localizacoesA = new ArrayList<Localizacao>() {{
        add(new Localizacao("-25.407151", "-49.268668"));
        add(new Localizacao("-25.407606", "-49.268700"));
        add(new Localizacao("-25.408014", "-49.268743"));
        add(new Localizacao("-25.408417", "-49.268755"));
        add(new Localizacao("-25.408839", "-49.268787"));
        add(new Localizacao("-25.408912", "-49.268213"));
        add(new Localizacao("-25.408965", "-49.267553"));
        add(new Localizacao("-25.408994", "-49.266990"));
        add(new Localizacao("-25.409042", "-49.266218"));
        add(new Localizacao("-25.408534", "-49.266456"));
        add(new Localizacao("-25.408123", "-49.266695"));
        add(new Localizacao("-25.407653", "-49.266883"));
        add(new Localizacao("-25.407241", "-49.266974"));
        add(new Localizacao("-25.407202", "-49.267468"));
        add(new Localizacao("-25.407183", "-49.268096"));
    }};

    private List<Localizacao> localizacoesB = new ArrayList<Localizacao>() {{
        add(new Localizacao("-25.407698", "-49.264267"));
        add(new Localizacao("-25.407807", "-49.263723"));
        add(new Localizacao("-25.407928", "-49.263294"));
        add(new Localizacao("-25.408035", "-49.262672"));
        add(new Localizacao("-25.408132", "-49.262178"));
        add(new Localizacao("-25.408549", "-49.262264"));
        add(new Localizacao("-25.408893", "-49.262382"));
        add(new Localizacao("-25.409184", "-49.262446"));
        add(new Localizacao("-25.409063", "-49.262945"));
        add(new Localizacao("-25.408966", "-49.263444"));
        add(new Localizacao("-25.409286", "-49.263465"));
        add(new Localizacao("-25.409596", "-49.263497"));
        add(new Localizacao("-25.409504", "-49.263958"));
        add(new Localizacao("-25.409407", "-49.264360"));
        add(new Localizacao("-25.409024", "-49.264360"));
        add(new Localizacao("-25.408612", "-49.264333"));
        add(new Localizacao("-25.408152", "-49.264290"));
    }};

    private Localizacao setLocalizacao(Vigilante vigilante) {
        int indice = localizacoesB.indexOf(vigilante.getLocalizacao()) + 1;

        if (indice == localizacoesB.size()) indice = 0;

        vigilante.setLocalizacao(localizacoesB.get(indice));

        service.editar(vigilante);

        return vigilante.getLocalizacao();
    }

    @RequestMapping("/vigilantes")
    public ModelAndView criar() {
        Vigilante vigilanteA = service.buscarPorId(1L);
        Vigilante vigilanteB = service.buscarPorId(2L);

        setLocalizacao(vigilanteA);
        setLocalizacao(vigilanteB);

        return new ModelAndView("vigilantes")
                .addObject("vigilanteA", vigilanteA)
                .addObject("vigilanteB", vigilanteB);
    }

}
