package astratech.dla_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import astratech.dla_api.service.*;
import astratech.dla_api.model.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
//@RequestMapping("/api/public")
public class ProdiController {
    @Autowired
    ProdiService service;

    @GetMapping("/getAllProdi")
    public List<msprodi> getAllUser(HttpServletResponse response){
        List<msprodi> prod= service.getAll();

        return prod;
    }


}
