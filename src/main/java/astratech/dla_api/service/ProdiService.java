package astratech.dla_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import astratech.dla_api.repository.*;
import astratech.dla_api.model.*;

import java.util.List;

@Service
public class ProdiService {
    @Autowired
    ProdiRepository repository;

    public List<msprodi> getAll() {
        List<msprodi> prod = repository.getbyStatus();
        return prod;
    }
}
