package astratech.dla_api.controller;


import astratech.dla_api.model.msuser;
import astratech.dla_api.model.trbookingdetail;
import astratech.dla_api.result.result;
import astratech.dla_api.service.BookingDetailService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    //post
    @PostMapping("/saveBookDetail")
    public result save(HttpServletResponse response, @RequestBody trbookingdetail bookdet) {
        trbookingdetail bookdet1=new trbookingdetail(bookdet.getId_transactiondetail(),bookdet.getId_transaction(),bookdet.getId_koleksi(),bookdet.getTanggalpinjam(),bookdet.getTanggalkembali(),bookdet.getStatus(),bookdet.getCreaby(),bookdet.getCreadate(),bookdet.getModiby(),bookdet.getModidate());
        boolean isSuccess = bookingdetService.save(bookdet1);
        if (isSuccess){
            return new result(200, "Success");
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new result(500, "Fail");
        }
    }

}
