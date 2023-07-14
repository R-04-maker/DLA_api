package astratech.dla_api.service;

import astratech.dla_api.model.msbanner;
import astratech.dla_api.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
    @Autowired
    BannerRepository bannerRepository;

    public msbanner getBannerbyName(String nama) {
        msbanner bannerByName = bannerRepository.getBannerbyName(nama);
        return bannerByName;
    }
    public List<msbanner> getBanners() {
        List<msbanner> banner = bannerRepository.getBanners();
        return banner;
    }
}
