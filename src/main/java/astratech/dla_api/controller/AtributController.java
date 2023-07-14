package astratech.dla_api.controller;

import astratech.dla_api.model.msatribut;
import astratech.dla_api.model.mskoleksi;
import astratech.dla_api.result.ResultKoleksi;
import astratech.dla_api.service.AtributService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@RestController
public class AtributController {
    @Autowired
    AtributService atributService;

    @GetMapping("/getAtribut")
    public msatribut getAtributbyName(HttpServletResponse response, @RequestParam("nama") String nama) {
        msatribut atribut = atributService.getAtributbyName(nama);
        return atribut;
    }

    @GetMapping("/getAtributs")
    public List<msatribut> getAtributs(HttpServletResponse response){
        List<msatribut> atribut = atributService.getAtributs();
        return atribut;
    }
}
