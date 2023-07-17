package astratech.dla_api.controller;

import astratech.dla_api.model.tratributkategori;
import astratech.dla_api.service.AtributKategoriService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AtributKategoriController {

    @Autowired
    AtributKategoriService kategoriService;

    @GetMapping("/getAtKategori")
    public List<tratributkategori> getAtKategori(HttpServletResponse response){
        List<tratributkategori> kategori = kategoriService.getAtKategori();
        return kategori;
    }
}
