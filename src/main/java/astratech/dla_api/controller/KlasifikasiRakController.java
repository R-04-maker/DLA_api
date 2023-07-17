package astratech.dla_api.controller;

import astratech.dla_api.model.trklasifikasirak;
import astratech.dla_api.service.KlasifikasiRakService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KlasifikasiRakController {
    @Autowired
    KlasifikasiRakService klasifikasiRakService;

    @GetMapping("/getKlasifikasiRak")
    public List<trklasifikasirak> getKlasifikasiRak(HttpServletResponse response){
        List<trklasifikasirak> klasifikasirak = klasifikasiRakService.getKlasifikasiRak();
        return klasifikasirak;
    }
}
