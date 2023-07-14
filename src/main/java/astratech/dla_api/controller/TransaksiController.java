package astratech.dla_api.controller;

import astratech.dla_api.model.trbooking;
import astratech.dla_api.result.ResultKoleksi;
import astratech.dla_api.result.ResultTransaksiBooking;
import astratech.dla_api.service.TransaksiService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

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
        List<trbooking> booking = transaksiService.getUnconfirmedBooking();
        if(booking != null){
            return new ResultTransaksiBooking(200, "Success", booking);
        }else {
            return new ResultTransaksiBooking(500,"Failed",null);
        }
    }
}
