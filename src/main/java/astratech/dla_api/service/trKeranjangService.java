package astratech.dla_api.service;

import astratech.dla_api.model.*;
import astratech.dla_api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class trKeranjangService {
    @Autowired
    trKeranjangRepository keranjangRepository;


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
}
