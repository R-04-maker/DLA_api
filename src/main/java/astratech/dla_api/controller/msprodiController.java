package astratech.dla_api.controller;

import astratech.dla_api.model.msuser;
import astratech.dla_api.result.ResultObject;
import astratech.dla_api.result.ResultProdi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import astratech.dla_api.service.*;
import astratech.dla_api.model.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class msprodiController {
    @Autowired
    msprodiService service;

    @GetMapping("/getAllProdi")
    public List<msprodi> getAllUser(HttpServletResponse response){
        List<msprodi> prod= service.getAll();

        return prod;
    }


}
