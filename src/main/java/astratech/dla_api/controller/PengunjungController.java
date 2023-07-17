package astratech.dla_api.controller;


import astratech.dla_api.model.trpengunjung;
import astratech.dla_api.service.PengunjungService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class PengunjungController {


    @Autowired
    PengunjungService pengunjungService;

    @PostMapping("/savePengunjung")
    public ResponseEntity<Void> save(HttpServletResponse response, @RequestParam String nim, String nama, String prodi){
         trpengunjung pengunjung = new trpengunjung(nim,nama,prodi);
         pengunjungService.save(pengunjung);

         return ResponseEntity.status(HttpStatus.FOUND).
                 location(URI.create("http://localhost:8080/")).build();
//
    }

    //get semua user
    @GetMapping("/getAllPengunjung")
    public List<trpengunjung> getAllPengunjung(HttpServletResponse response){
        List<trpengunjung> pengunjung = pengunjungService.getAllPengunjung();
        return pengunjung;
    }



}
