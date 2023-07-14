package astratech.dla_api.service;


import astratech.dla_api.model.trdenda;
import astratech.dla_api.repository.DendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DendaService {

    @Autowired
    DendaRepository dendaRepository;

    public List<trdenda> getAllDenda() {
        List<trdenda> denda = dendaRepository.getAllDenda();
        return denda;
    }
}
