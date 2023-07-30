package astratech.dla_api.controller;

import astratech.dla_api.model.msbanner;
import astratech.dla_api.model.mskoleksi;
import astratech.dla_api.service.BannerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@RestController
public class BannerController {
    @Autowired
    BannerService bannerService;

    @GetMapping("/getBanner")
    public msbanner getBannerbyName(HttpServletResponse response, @RequestParam("nama") String nama) {
        msbanner banner = bannerService.getBannerbyName(nama);
        return banner;
    }

    @GetMapping("/getBanners")
    public List<msbanner> getBanners(HttpServletResponse response){
        List<msbanner> banner = bannerService.getBanners();

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
        for (msbanner banners : banner) {
            if (!banners.getBerkas().equals("KOSONG") && !banners.getBerkas().equals("IMG_NoImage.jpg") ) {
                String imagePath = baseUrl + "/img/banner/" + banners.getBerkas();
                banners.setBerkas(imagePath);
            }
        }
        return banner;
    }
}
