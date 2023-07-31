package astratech.dla_api.controller;

import astratech.dla_api.model.*;
import astratech.dla_api.result.ResultKeranjang;
import astratech.dla_api.result.ResultObject;
import astratech.dla_api.result.ResultString;
import astratech.dla_api.result.result;
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

        trKeranjang keranjang1 = new trKeranjang(keranjang.getId_keranjang(),keranjang.getEmail(), keranjang.getId_koleksi());
        boolean isSuccess = keranjangService.save(keranjang1);
        System.out.println(keranjang.getId_keranjang());
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
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
            for (trKeranjang data : keranjang) {
                if (!data.getId_koleksi().getGambar().equals("KOSONG") && !data.getId_koleksi().getGambar().equals("IMG_NoImage.jpg") ) {
                    String imagePath = baseUrl + "/img/koleksi/" + data.getId_koleksi().getGambar();
                    data.getId_koleksi().setGambar(imagePath);
                }
            }
            return new ResultKeranjang("Success",200, keranjang);
        }
         return keranjang;
    }

    @GetMapping("/cekKeranjang/{email}/{idKoleksi}")
    public  Object CekKeranjang(@PathVariable String email, @PathVariable String idKoleksi){
        boolean keranjang = keranjangService.cekKeranjang(email, idKoleksi);
        if (keranjang) {
            return new result(200,"Data sudah pernah ditambahkan");
        }else {
            return new result(500, "Data belum ada");
        }
    }
}
