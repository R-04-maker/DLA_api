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
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class TransaksiController {
    @Autowired
    TransaksiService transaksiService;

    @Value("src/main/resources/static/img/foto_peminjaman/")
    private String uploadDir;

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
            if(!a[10].toString().equals(null)){
                String imagePath = baseUrl + "/img/foto_peminjaman/" + a[10].toString();
                a[10] = imagePath;
            }
            if(!a[11].toString().equals(null)){
                String imagePath = baseUrl + "/img/foto_peminjaman/" + a[11].toString();
                a[11] = imagePath;
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

        // Save file to the specified directory
//            byte[] bytes = file.getBytes();
        String filename = file.getOriginalFilename();
        Path path = Paths.get(uploadDir + filename);
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
