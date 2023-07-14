package astratech.dla_api.service;


import astratech.dla_api.model.tratributkategori;
import astratech.dla_api.repository.AtributKategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtributKategoriService {

    @Autowired
    AtributKategoriRepository kategoriRepository;

    public List<tratributkategori> getAtKategori() {
        List<tratributkategori> kategori = kategoriRepository.getAtKategori();
        return kategori;
    }
}
