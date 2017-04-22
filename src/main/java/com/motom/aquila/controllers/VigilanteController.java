package com.motom.aquila.controllers;

import com.motom.aquila.models.Localizacao;
import com.motom.aquila.models.Vigilante;
import com.motom.aquila.services.contracts.VigilanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    private List<Localizacao> localizacoesC = new ArrayList<Localizacao>() {{
        add(new Localizacao("-25.410845", "-49.263984"));
        add(new Localizacao("-25.410922", "-49.263512"));
        add(new Localizacao("-25.411029", "-49.262946"));
        add(new Localizacao("-25.411107", "-49.262431"));
        add(new Localizacao("-25.411189", "-49.262023"));
        add(new Localizacao("-25.411267", "-49.261605"));
        add(new Localizacao("-25.411548", "-49.261680"));
        add(new Localizacao("-25.412008", "-49.261793"));
        add(new Localizacao("-25.412449", "-49.261879"));
        add(new Localizacao("-25.412367", "-49.262437"));
        add(new Localizacao("-25.412265", "-49.263027"));
        add(new Localizacao("-25.412139", "-49.263703"));
        add(new Localizacao("-25.411713", "-49.263746"));
        add(new Localizacao("-25.411243", "-49.263832"));
    }};

    private List<Localizacao> localizacoesAtoB = new ArrayList<Localizacao>() {{
        add(new Localizacao("-25.409407", "-49.264360"));
        add(new Localizacao("-25.409780", "-49.264405"));
        add(new Localizacao("-25.410526", "-49.264190"));
        add(new Localizacao("-25.411243", "-49.263832"));
        add(new Localizacao("-25.411713", "-49.263746"));
        add(new Localizacao("-25.412139", "-49.263703"));
        add(new Localizacao("-25.412529", "-49.263690"));
        add(new Localizacao("-25.412839", "-49.263714"));
        add(new Localizacao("-25.412752", "-49.264401"));
        add(new Localizacao("-25.412720", "-49.264938"));
        add(new Localizacao("-25.412633", "-49.265566"));
        add(new Localizacao("-25.412535", "-49.265982"));
        add(new Localizacao("-25.412438", "-49.266872"));
    }};

    private Localizacao setLocalizacao(Vigilante vigilante, List<Localizacao> localizacoes, boolean reverso) {
        int indice;

        if (reverso) {
            indice = localizacoes.indexOf(vigilante.getLocalizacao()) - 1;
            if (indice == localizacoes.size()) {
                vigilante.setLocalizacao(localizacoesA.get(localizacoes.size() - 1));
            }
        } else {
            indice = localizacoes.indexOf(vigilante.getLocalizacao()) + 1;
            if (indice == localizacoes.size()) indice = 0;
            vigilante.setLocalizacao(localizacoes.get(indice));
        }

        service.editar(vigilante);

        return vigilante.getLocalizacao();
    }

    @RequestMapping("/vigilantes")
    public ModelAndView buscar(String opcao) {
        Vigilante vigilante = null;
        switch (opcao) {
            case "A":
                vigilante = service.buscarPorId(1L);
                setLocalizacao(vigilante, localizacoesA, false);
                break;
            case "B":
                vigilante = service.buscarPorId(2L);
                setLocalizacao(vigilante, localizacoesB, false);
                break;
            case "C":
                vigilante = service.buscarPorId(3L);
                setLocalizacao(vigilante, localizacoesC, false);
                break;
            case "AtoB":
                vigilante = service.buscarPorId(1L);
                setLocalizacao(vigilante, localizacoesAtoB, false);
                break;
        }

        return new ModelAndView("vigilantes")
                .addObject("vigilante", vigilante);
    }

    @RequestMapping("/retornar")
    public ModelAndView retornar() {
        Vigilante vigilante = service.buscarPorId(1L);
        setLocalizacao(vigilante, localizacoesAtoB, true);

        return new ModelAndView("vigilantes")
                .addObject("vigilante", vigilante);
    }

}
