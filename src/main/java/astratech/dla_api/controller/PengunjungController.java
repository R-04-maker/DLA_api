package astratech.dla_api.controller;


import astratech.dla_api.model.trpengunjung;
import astratech.dla_api.service.PengunjungService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pengunjung")
public class PengunjungController {

    @Autowired
    PengunjungService pengunjungService;

    @PostMapping("/savePengunjung")
    public ResponseEntity<String> save(@RequestParam String nim, String nama, String prodi) {
        Date date = new Date();
        trpengunjung pengunjung = new trpengunjung(0,nim, nama, prodi,nim,date,nim,date);
        pengunjungService.save(pengunjung);

        return ResponseEntity.ok("Data berhasil disimpan"); // Mengembalikan pesan sukses
    }

    @GetMapping("/Absensi")
    public ResponseEntity<Void> pageAbsensi(){
        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/index.html")).build();
    }

    //get semua user
    @GetMapping("/getAllPengunjung")
    public List<trpengunjung> getAllPengunjung(HttpServletResponse response){
        List<trpengunjung> pengunjung = pengunjungService.getAllPengunjung();
        return pengunjung;
    }



}
