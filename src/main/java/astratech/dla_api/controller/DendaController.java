package astratech.dla_api.controller;


import astratech.dla_api.model.trdenda;
import astratech.dla_api.service.DendaService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DendaController {

    @Autowired
    DendaService dendaService;

    @GetMapping("/getAllDenda")
    public List<trdenda> getAllDenda(HttpServletResponse response){
        List<trdenda> denda = dendaService.getAllDenda();
        return denda;
    }
}
