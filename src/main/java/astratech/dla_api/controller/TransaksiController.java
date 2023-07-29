package astratech.dla_api.controller;

import astratech.dla_api.model.trbooking;
import astratech.dla_api.result.ResultObject;
import astratech.dla_api.result.ResultString;
import astratech.dla_api.result.ResultTransaksiBooking;
import astratech.dla_api.result.result;
import astratech.dla_api.service.TransaksiService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
public class TransaksiController {
    @Autowired
    TransaksiService transaksiService;

    @Value("src/main/resources/static/img/")
    private String uploadDir;

    @GetMapping("/getBooking")
    public List<trbooking> getBooking(HttpServletResponse response){
        List<trbooking> booking = transaksiService.getBooking();
        return booking;
    }

    //deletebooking
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
        trbooking booking1=new trbooking(booking.getId_transaction(),booking.getEmail(),booking.getBookingonline(),booking.getStatus(),booking.getCreaby(),booking.getCreadate(),booking.getModiby(),booking.getModidate());
        boolean isSuccess = transaksiService.save(booking1);
        if (isSuccess){
            return new result(200, "Success");
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
//            System.out.println(imageA);
//            System.out.println(data.length);
/*            if(!data[10].equals(null) && !data[11].equals(null)){
                String imagePath = baseUrl + "/assets/images/" + data[10].toString();
                String imagePaths = baseUrl + "/assets/images/" + data[11].toString();
                data[10] = imagePath;
                data[11] = imagePaths;
            }*/
            return new ResultObject(200,"Success",data, listdata);
        }else {
            return new ResultObject(500,"Failed",null, null);
        }
    }
    @GetMapping("/updatePengajuan/{id}/{status}")
    public Object updatePengajuan(@PathVariable int id, @PathVariable String status){
        String data = transaksiService.updatePengajuan(id,status);
        if (data != null ) {
            return new ResultString(200,"Success",data);
        }else {
            return new ResultString(500,"Failed",null);
        }
    }

/*    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("idBooking") int idbooking){
        try{
            String filename = transaksiService.saveFile(file,idbooking);
            return ResponseEntity.ok("File uploaded success. File name: " + filename);
        }catch (IOException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload File");
        }
    }*/
    @PostMapping("/updateGambar")
    public Object updateGambar(@RequestParam("encodedImage") MultipartFile file,
                               @RequestParam("status") String status,
                               @RequestParam("id") int id){
        try{
            if(file.isEmpty()){
                return new ResponseEntity<>("Image is required", HttpStatus.BAD_REQUEST);
            }

            // Save file to the specified directory
            byte[] bytes = file.getBytes();
            String filename = file.getOriginalFilename();
            Path path = Paths.get(uploadDir + filename);
            Files.write(path,bytes);

            // Update filename and status
            System.out.println(id + filename + status);
            String data = transaksiService.updateBooking(id,filename,status);
            if (data != null ) {
                return new ResultString(200,"Success",data);
            }else {
                return new ResultString(500,"Failed",null);
            }
        }catch (IOException e){
            e.printStackTrace();
            return new ResultString(200,"Failed","Gagal");
        }
    }

    @GetMapping("/image/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        try {
            Path file = Paths.get(uploadDir + filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists()) {
                // Membangun URL lengkap dari sumber daya (gambar) menggunakan ServletUriComponentsBuilder
                String fileUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/image/")
                        .path(filename)
                        .toUriString();

                // Mengatur header untuk memberi tahu klien tentang lokasi gambar
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.LOCATION, fileUrl);

                return ResponseEntity
                        .ok()
                        .headers(headers)
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
}
