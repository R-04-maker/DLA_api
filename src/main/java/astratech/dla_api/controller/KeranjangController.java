package astratech.dla_api.controller;

import astratech.dla_api.model.*;
import astratech.dla_api.result.ResultKeranjang;
import astratech.dla_api.result.ResultObject;
import astratech.dla_api.result.result;
import astratech.dla_api.result.resultLogin;
import astratech.dla_api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
public class KeranjangController {
    @Autowired
    KeranjangService keranjangService;

    //save user
    @PostMapping("/saveKeranjang")
    public result save(HttpServletResponse response, @RequestBody trKeranjang keranjang) {

        trKeranjang keranjang1=new trKeranjang(keranjang.getId_keranjang(),keranjang.getEmail(), keranjang.getId_koleksi());
        boolean isSuccess = keranjangService.save(keranjang1);

        if (isSuccess){
            return new result(200, "Success");
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new result(500, "Fail");
        }

    }

    //deletekeranjang
    @DeleteMapping("/deleteKeranjang/{id}")
    public result delete(HttpServletResponse response, @PathVariable int id) {
        boolean isSuccess = keranjangService.delete(id);

        if (isSuccess){
            return new result(200, "Success");
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new result(500, "Fail");
        }
    }

    @GetMapping("/getAllKeranjang/{email}")
    public  Object getDetailBooking(@PathVariable String email){
        List<trKeranjang> keranjang = keranjangService.getAllKeranjangById(email);
        if (keranjang != null) {
            return new ResultKeranjang("Success",200, keranjang);
        }
         return keranjang;
    }
}
