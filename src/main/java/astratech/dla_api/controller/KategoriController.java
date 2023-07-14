package astratech.dla_api.controller;

import astratech.dla_api.model.mskategori;
import astratech.dla_api.service.KategoriService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KategoriController {

    @Autowired
    KategoriService kategoriService;

    @GetMapping("/getKategori")
    public mskategori getKategori(HttpServletResponse response, @RequestParam("nama") String nama) {
        mskategori kategori = kategoriService.getKategori(nama);
        return kategori;
    }

    //get semua user
    @GetMapping("/getAllKategori")
    public List<mskategori> getAllKategori(HttpServletResponse response){
        List<mskategori> mskategoris = kategoriService.getAllKategori();
        return mskategoris;
    }
}
