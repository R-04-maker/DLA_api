package astratech.dla_api.service;

import astratech.dla_api.model.msatribut;
import astratech.dla_api.repository.AtributRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtributService {
    @Autowired
    AtributRepository atributRepository;

    public msatribut getAtributbyName(String nama) {
        msatribut atributbyName = atributRepository.getAtributbyName(nama);
        return atributbyName;
    }
    public List<msatribut> getAtributs() {
        List<msatribut> atribut = atributRepository.getAtributs();
        return atribut;
    }
}
