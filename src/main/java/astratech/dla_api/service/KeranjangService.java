package astratech.dla_api.service;

import astratech.dla_api.model.*;
import astratech.dla_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeranjangService {
    @Autowired
    KeranjangRepository keranjangRepository;


    public boolean save(trKeranjang keranjang) {
        trKeranjang result = keranjangRepository.save(keranjang);

        boolean isSuccess = true;
        if (result == null) {
            isSuccess = false;
        }
        return isSuccess;
    }

    public boolean delete(int id) {
        keranjangRepository.deleteById(id);
        return true;
    }

    public List<trKeranjang> getAllKeranjangById(String email) {
        List<trKeranjang> keranjang = keranjangRepository.getAllKeranjangById(email);
        return keranjang;
    }

    public boolean cekKeranjang(String email, String idKoleksi) {
        trKeranjang result = keranjangRepository.cekKeranjang(email, idKoleksi);

        boolean isSuccess = true;
        if (result == null) {
            isSuccess = false;
        }
        return isSuccess;
    }
}
