package astratech.dla_api.service;


import astratech.dla_api.model.trpengunjung;
import astratech.dla_api.repository.PengunjungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PengunjungService {

    @Autowired
    PengunjungRepository userRepo;


    public boolean save(trpengunjung dla) {
        trpengunjung result = userRepo.save(dla);

        boolean isSuccess = true;
        if (result == null) {
            isSuccess = false;
        }
        return isSuccess;
    }

    public List<trpengunjung> getAllPengunjung() {
        List<trpengunjung> pengunjung = userRepo.getAllPengunjung();
        return pengunjung;
    }

}
