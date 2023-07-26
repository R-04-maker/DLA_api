package astratech.dla_api.service;

import astratech.dla_api.model.msuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import astratech.dla_api.repository.*;
import astratech.dla_api.model.*;

import java.util.List;

@Service
public class msprodiService {
    @Autowired
    msprodiRepository repository;

    public List<msprodi> getAll() {
        List<msprodi> prod = repository.findAll();
        return prod;
    }


}
