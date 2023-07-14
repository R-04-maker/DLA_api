package astratech.dla_api.controller;


import astratech.dla_api.model.msklasifikasi;
import astratech.dla_api.service.KlasifikasiService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KlasifikasiController {

    @Autowired
    KlasifikasiService klasifikasiService;


    @GetMapping("/getKlasifikasi")
    public msklasifikasi getKlasifikasi(HttpServletResponse response, @RequestParam("nama") String nama) {
        msklasifikasi klasifi = klasifikasiService.getKlasifikasi(nama);
        return klasifi;
    }
    //get semua user
    @GetMapping("/getAllKlasifikasi")
    public List<msklasifikasi> getAllKlasifikasi(HttpServletResponse response){
        List<msklasifikasi> klasifi = klasifikasiService.getAllKlasifikasi();
        return klasifi;
    }
}
