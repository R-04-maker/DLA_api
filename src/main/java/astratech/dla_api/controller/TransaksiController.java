package astratech.dla_api.controller;

import astratech.dla_api.model.trbooking;
import astratech.dla_api.result.ResultObject;
import astratech.dla_api.result.ResultTransaksiBooking;
import astratech.dla_api.service.TransaksiService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@RestController
public class TransaksiController {
    @Autowired
    TransaksiService transaksiService;

    @GetMapping("/getBooking")
    public List<trbooking> getBooking(HttpServletResponse response){
        List<trbooking> booking = transaksiService.getBooking();
        return booking;
    }
    @GetMapping("/getUnconfirmedBooking")
    public Object getUnconfirmedBooking(HttpServletResponse response){
        List<Object[]> booking = transaksiService.getUnconfirmedBooking();
        if(booking != null){
            return new ResultObject(200, "Success", booking);
        }else {
            return new ResultTransaksiBooking(500,"Failed",null);
        }
    }

    @GetMapping("/getDetailBooking/{id}")
    public Object getDetailBooking(@PathVariable int id){
        Object[] data = transaksiService.getDetailBooking(id);
        List<Object[]> listdata = transaksiService.getBukuDetailBooking(id);
        if (data != null && data.length > 0) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
            for(Object[] obj : listdata){
                if(!obj[3].toString().equals("KOSONG") && !obj[3].toString().equals("IMG_NoImage.jpg")){
                    String imagePath = baseUrl + "/assets/images/" + obj[3].toString();
                    obj[3] = imagePath;
                }
            }
            return new ResultObject(200,"Success",data, listdata);
        }else {
            return new ResultObject(500,"Failed",null, null);
        }
    }

}
