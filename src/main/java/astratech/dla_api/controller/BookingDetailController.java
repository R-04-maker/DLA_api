package astratech.dla_api.controller;


import astratech.dla_api.model.trbookingdetail;
import astratech.dla_api.service.BookingDetailService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingDetailController {

    @Autowired
    BookingDetailService bookingdetService;
    //get all
    @GetMapping("/getBookdet")
    public List<trbookingdetail> getBookdet(HttpServletResponse response){
        List<trbookingdetail> bookdet = bookingdetService.getBookdet();
        return bookdet;
    }
}
