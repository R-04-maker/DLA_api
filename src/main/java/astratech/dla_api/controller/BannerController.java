package astratech.dla_api.controller;

import astratech.dla_api.model.msbanner;
import astratech.dla_api.service.BannerService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        return banner;
    }
}
