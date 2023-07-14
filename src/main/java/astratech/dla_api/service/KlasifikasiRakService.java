package astratech.dla_api.service;

import astratech.dla_api.model.trklasifikasirak;
import astratech.dla_api.repository.KlasifikasiRakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlasifikasiRakService {
    @Autowired
    KlasifikasiRakRepository klasifikasiRakRepository;

    public List<trklasifikasirak> getKlasifikasiRak() {
        List<trklasifikasirak> klasifikasirak = klasifikasiRakRepository.getKlasifikasiRak();
        return klasifikasirak;
    }
}
