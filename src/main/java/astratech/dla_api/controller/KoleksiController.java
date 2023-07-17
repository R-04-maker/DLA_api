package astratech.dla_api.controller;

import astratech.dla_api.model.mskoleksi;
import astratech.dla_api.result.ResultKoleksi;
import astratech.dla_api.service.KoleksiService;

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
public class KoleksiController {
    @Autowired
    KoleksiService mskoleksiServie;

    @GetMapping("/getKoleksi")
    public Object getKoleksi(){
        List<mskoleksi> dlaMskoleksis = mskoleksiServie.getAll();
        if(dlaMskoleksis != null){
            return new ResultKoleksi(200, "Success", dlaMskoleksis);
        }else {
            return new ResultKoleksi(500,"Failed",null);
        }
    }

    @GetMapping("/getNewestCollection")
    public Object getNewestCollection(){
        List<mskoleksi> dlaMskoleksis = mskoleksiServie.getNewestbyCreadate();
        if(dlaMskoleksis != null){
            return new ResultKoleksi(200, "Success", dlaMskoleksis);
        }else {
            return new ResultKoleksi(500,"Failed",null);
        }
    }

    @GetMapping("/getNewestReleased")
    public Object getNewestReleased(){
        List<mskoleksi> dlaMskoleksis = mskoleksiServie.getNewestbyTahunterbit();
        if(dlaMskoleksis != null){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
            for (mskoleksi koleksi : dlaMskoleksis) {
                if (!koleksi.getGambar().equals("KOSONG") && !koleksi.getGambar().equals("IMG_NoImage.jpg") ) {
                    String imagePath = baseUrl + "/assets/images/" + koleksi.getGambar();
                    koleksi.setGambar(imagePath);
                }
            }
            return new ResultKoleksi(200, "Success", dlaMskoleksis);
        }else {
            return new ResultKoleksi(500,"Failed",null);
        }
    }

    @GetMapping("/getPopularBook")
    public Object getPopular(){
        List<mskoleksi> dlaMsKoleksis = mskoleksiServie.getPopular();
        if(dlaMsKoleksis != null){
            if(dlaMsKoleksis.size() < 10){
                List<mskoleksi> mskoleksis = mskoleksiServie.getAll();
                return new ResultKoleksi(200, "Success get All data", mskoleksis);
            }else {
                return new ResultKoleksi(200, "Success get Popular", dlaMsKoleksis);
            }
        }else {
            return new ResultKoleksi(500,"Failed",null);
        }
    }

    @GetMapping("/getDataDashboard")
    public List<Object[]> getDataDashboard(){
        List<Object[]> data = mskoleksiServie.getDataDashboard();
        return data;
    }
    @GetMapping("/getDetailKoleksi/{id}")
    public List<Object[]> getDetailKoleksi(@PathVariable int id){
        // array index 5
        List<Object[]> data = mskoleksiServie.getDetailKoleksi(id);
        if(data != null){
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
            Object[] element = data.get(0);
            String value = element[5].toString();
            if(!value.equals("KOSONG") && !value.equals("IMG_NoImage.jpg")){
                String imagePath = baseUrl + "/assets/images/" + value;
                element[5] = imagePath;
            }
            return data;
        }else {
            return data;
        }
    }

    @GetMapping("/getDetailAtribut/{id}")
    public List<Object[]> getDetailAtribut(@PathVariable int id){
        List<Object[]> data = mskoleksiServie.getAtributDetail(id);
        return data;
    }

    @GetMapping("/getKlasifikasiDetail/{id}")
    public List<Object[]> getKlasifikasiDetail(@PathVariable int id){
        List<Object[]> data = mskoleksiServie.getKlasifikasiDetail(id);
        return data;
    }
}