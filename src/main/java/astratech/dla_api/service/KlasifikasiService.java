package astratech.dla_api.service;


import astratech.dla_api.model.msklasifikasi;
import astratech.dla_api.repository.KlasifikasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlasifikasiService {

    @Autowired
    KlasifikasiRepository klasifikasiRepository;

    public msklasifikasi getKlasifikasi(String nama) {
        msklasifikasi klasifi = klasifikasiRepository.getklasifikasi(nama);
        return klasifi;
    }

    //untuk get semua data
    public List<msklasifikasi> getAllKlasifikasi() {
        List<msklasifikasi> klasifi = klasifikasiRepository.getAllKlasifikasi();
        return klasifi;
    }



}
