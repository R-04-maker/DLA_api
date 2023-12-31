package astratech.dla_api.controller;

import astratech.dla_api.model.msuser;
import astratech.dla_api.model.trbooking;
import astratech.dla_api.model.trbookingdetail;
import astratech.dla_api.result.ResultObject;
import astratech.dla_api.result.ResultString;
import astratech.dla_api.result.ResultTransaksiBooking;
import astratech.dla_api.result.result;
import astratech.dla_api.service.FcmNotificationService;
import astratech.dla_api.service.TransaksiService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import astratech.dla_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class TransaksiController {
    @Autowired
    TransaksiService transaksiService;
    @Autowired
    ResourceLoader resourceLoader;
    @Autowired
    UserService userService;
    @Autowired
    FcmNotificationService fcmNotificationService;

    @Value("src/main/resources/static/img/foto_peminjaman/")
    private String uploadDir;

    @GetMapping("/getBooking")
    public List<trbooking> getBooking(HttpServletResponse response){
        List<trbooking> booking = transaksiService.getBooking();
        return booking;
    }



    @DeleteMapping("/deleteBooking/{id}")
    public result delete(HttpServletResponse response, @PathVariable int id) {
        boolean isSuccess = transaksiService.delete(id);

        if (isSuccess){
            return new result(200, "Success");
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new result(500, "Fail");
        }
    }

    @PostMapping("/saveBooking")
    public result save(HttpServletResponse response, @RequestBody trbooking booking) {
        System.out.println(booking.getBookingonline());
        Date currentDate = new Date();

        // Buat objek SimpleDateFormat untuk format datetime yang diinginkan
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = dateFormat.format(currentDate);
        trbooking booking1 = new trbooking(booking.getId_transaction(),booking.getEmail(),booking.getBookingonline(),booking.getStatus(),booking.getCreaby(),formattedDateTime,booking.getModiby(),formattedDateTime,booking.getGambar(), booking.getGambar_sesudah());
        trbooking savedBooking = transaksiService.save(booking1);
        int idTransaction = savedBooking.getId_transaction();
        System.out.println(idTransaction);

        // Get token by Role with Role ROL01
        List<msuser> data = userService.getUserByRole("ROL01");

        for(msuser admin : data){
            fcmNotificationService.sendNotification(admin.getToken(), "Peminjaman Baru",   "Id Booking : " + booking.getBookingonline());
        }

        if (idTransaction > 0){
            return new result(idTransaction, "Success");
        }else{
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new result(500, "Fail");
        }
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

    @GetMapping("/getConfirmedBooking")
    public Object getConfirmedBooking(HttpServletResponse response){
        List<Object[]> booking = transaksiService.getConfirmedBooking();
        if(booking != null){
            return new ResultObject(200, "Success", booking);
        }else {
            return new ResultTransaksiBooking(500,"Failed",null);
        }
    }

    @GetMapping("/getBorrowedBooking")
    public Object getBorrowedBooking(HttpServletResponse response){
        List<Object[]> booking = transaksiService.getBorrowedBooking();
        if(booking != null){
            return new ResultObject(200, "Success", booking);
        }else {
            return new ResultTransaksiBooking(500,"Failed",null);
        }
    }

    @GetMapping("/getFinishedBooking")
    public Object getFinishedBooking(HttpServletResponse response){
        List<Object[]> booking = transaksiService.getFinishedBooking();
        if(booking != null){
            return new ResultObject(200, "Success", booking);
        }else {
            return new ResultTransaksiBooking(500,"Failed",null);
        }
    }

        @GetMapping("/getHistoryMember/{email}")
    public Object getHistoryMember(HttpServletResponse response,@PathVariable String email){
        List<Object[]> booking = transaksiService.getHistoryMember(email);
        if(booking != null){
            return new ResultObject(200, "Success", booking);
        }else {
            return new ResultTransaksiBooking(500,"Failed",null);
        }
    }

    @GetMapping("/getValidasiAddKeranjang/{email}")
    public Object getValidasiAddKeranjang(HttpServletResponse response,@PathVariable String email){
        List<Object[]> booking = transaksiService.getValidasiAddKeranjang(email);
        if(booking != null){
            return new ResultObject(200, "Success", booking);
        }else {
            return new ResultTransaksiBooking(500,"Failed",null);
        }
    }


    @GetMapping("/getAllBooking")
    public Object getAllBooking(HttpServletResponse response){
        List<Object[]> booking = transaksiService.getAllBooking();
        if(booking != null){
            return new ResultObject(200, "Success", booking);
        }else {
            return new ResultTransaksiBooking(500,"Failed",null);
        }
    }

    @GetMapping("/getDetailBooking/{id}")
    public Object getDetailBooking(@PathVariable int id){
        List<Object[]> data = transaksiService.getDetailBooking(id);
        List<Object[]> listdata = transaksiService.getBukuDetailBooking(id);
        if (data != null && data.size() > 0) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
            for(Object[] obj : listdata){
                if(!obj[3].toString().equals("KOSONG") && !obj[3].toString().equals("IMG_NoImage.jpg")){
                    String imagePath = baseUrl + "/img/koleksi/" + obj[3].toString();
                    obj[3] = imagePath;
                }
            }
            Object[] a = data.get(0);
            System.out.println(a[10].toString());
            if(!a[11].toString().equals("")){
                String imagePath = baseUrl + "/img/foto_peminjaman/" + a[11].toString();
                a[11] = imagePath;
            }
            if(!a[12].toString().equals("")){
                String imagePath = baseUrl + "/img/foto_peminjaman/" + a[12].toString();
                a[12] = imagePath;
            }
            return new ResultObject(200,"Success",data, listdata);
        }else {
            return new ResultObject(500,"Failed",null, null);
        }
    }

    @GetMapping("/updatePengajuan/{id}/{status}")
    public Object updatePengajuan(@PathVariable int id, @PathVariable String status){
        String data = transaksiService.updatePengajuan(id,status);
        if (data != null ) {
            // Send Feedback Notif to Member
            // get Token
            trbooking dataBooking = transaksiService.getByIdBooking(id);
            msuser member = userService.getUserByEmail(dataBooking.getEmail());
            // send notif with message status if status = Ditolak
            if(status.equals("Ditolak")){
                fcmNotificationService.sendNotification(member.getToken(), "Feedback Pengajuan Peminjaman",   "Peminjaman dengan Id Booking : " + id + " " + status);
            }else {
                fcmNotificationService.sendNotification(member.getToken(), "Feedback Pengajuan Peminjaman",   "Peminjaman dengan Id Booking : " + id + " " + status);
            }
            return new ResultString(200,"Success",data);
        }else {
            return new ResultString(500,"Failed",null);
        }
    }
    @PostMapping("/updateGambar")
    public Object updateGambar(@RequestParam("encodedImage") MultipartFile file,
                               @RequestParam("status") String status,
                               @RequestParam("id") int id) throws IOException{
        if(file.isEmpty()){
            return new ResultString(500,"Failed",null);
        }
        Resource resource = resourceLoader.getResource("classpath:static/img/foto_peminjaman");
        String uploadDirectory = resource.getFile().getAbsolutePath().replace("\\", "/");

        // Save file to the specified directory
        String filename = file.getOriginalFilename();
        Path path = Paths.get(uploadDirectory +"/"+ filename);
        try(InputStream sourcePath = file.getInputStream()){
            Files.copy(sourcePath,path, StandardCopyOption.REPLACE_EXISTING);
        }

        // Update filename and status
        System.out.println(id + filename + status);
        String data = transaksiService.updateBooking(id,filename,status);
        if (data != null ) {
            return new ResultString(200,"Success",data);
        }else {
            return new ResultString(500,"Failed",null);
        }
    }
    @PostMapping("/saveBanner")
    public Object updateGambar(@RequestParam("encodedImage") MultipartFile file) throws IOException{
        if(file.isEmpty()){
            return new ResultString(500,"Failed",null);
        }

        // Save file to the specified directory
//            byte[] bytes = file.getBytes();
        String filename = file.getOriginalFilename();
        Path path = Paths.get("src/main/resources/static/img/banner/" + filename);
        try(InputStream sourcePath = file.getInputStream()){
            Files.copy(sourcePath,path, StandardCopyOption.REPLACE_EXISTING);
        }
        if (file.isEmpty() ) {
            return new ResultString(500, "Failed: File is empty", null);
        }else {
            return new ResultString(500,"sukses","berhasil");
        }
    }
    @GetMapping("/image/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) throws MalformedURLException {
        // Ganti "uploadDir" dengan direktori tempat gambar Anda disimpan pada server
        String uploadDir = "src/main/resources/static/img/banner/";

        // Dapatkan path lengkap untuk gambar
        Path imagePath = Paths.get(uploadDir, imageName);
        Resource imageResource = new UrlResource(imagePath.toUri());

        if (imageResource.exists() && imageResource.isReadable()) {
            return ResponseEntity.ok().body(imageResource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
