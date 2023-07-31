package astratech.dla_api.controller;


import astratech.dla_api.model.msuser;
import astratech.dla_api.model.trbooking;
import astratech.dla_api.model.trbookingdetail;
import astratech.dla_api.result.result;
import astratech.dla_api.service.BookingDetailService;
import javax.servlet.http.HttpServletResponse;

import astratech.dla_api.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class BookingDetailController {

    @Autowired
    BookingDetailService bookingdetService;

    @Autowired
    TransaksiService transaksiService;
    //get all
    @GetMapping("/getBookdet")
    public List<trbookingdetail> getBookdet(HttpServletResponse response){
        List<trbookingdetail> bookdet = bookingdetService.getBookdet();
        return bookdet;
    }

    //post
    @PostMapping("/saveBookDetail")
    public result save(HttpServletResponse response, @RequestBody trbookingdetail bookdet) throws ParseException {

        DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date tanggalPinjam = sourceFormat.parse(bookdet.getTanggalpinjam());
        Date tanggalKembali = sourceFormat.parse(bookdet.getTanggalkembali());

        String tglPinjamFormatted = targetFormat.format(tanggalPinjam);
        String tglKembaliFormatted = targetFormat.format(tanggalKembali);

        Date currentDate = new Date();
        String currentDateFormatted = targetFormat.format(currentDate);

        trbookingdetail bookdet1 = new trbookingdetail(bookdet.getId_transactiondetail(),bookdet.getId_transaction(),bookdet.getId_koleksi(),tglPinjamFormatted,tglKembaliFormatted,bookdet.getStatus(),bookdet.getCreaby(),currentDateFormatted,bookdet.getModiby(),currentDateFormatted);

        // Update statuspinjam koleksi
        bookingdetService.updateStatusPinjam(bookdet.getId_koleksi().getId_koleksi(), 0);
        boolean isSuccess = bookingdetService.save(bookdet1);
        // get email by id_transaction
        trbooking data = transaksiService.getBookingById(bookdet.getId_transaction().getId_transaction());
        bookingdetService.deleteKeranjang(data.getEmail(), bookdet.getId_koleksi().getId_koleksi());
        System.out.println("Email : " + data.getEmail());
        System.out.println("Id Koleksi : " + bookdet.getId_koleksi().getId_koleksi());
        if (isSuccess){
            return new result(200, "Success");
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new result(500, "Fail");
        }
    }

}
