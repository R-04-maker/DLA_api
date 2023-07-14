package astratech.dla_api.service;


import astratech.dla_api.model.mskategori;
import astratech.dla_api.repository.KategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategoriService {

    @Autowired
    KategoriRepository kategoriRepository;

    public mskategori getKategori(String nama) {
        mskategori kategori = kategoriRepository.getkategoriNama(nama);
        return kategori;
    }

    public List<mskategori> getAllKategori() {
        List<mskategori> mskategoris = kategoriRepository.getAllKategori();
        return mskategoris;
    }
}
