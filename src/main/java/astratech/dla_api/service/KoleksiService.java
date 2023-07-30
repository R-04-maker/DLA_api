package astratech.dla_api.service;


import astratech.dla_api.model.mskoleksi;
import astratech.dla_api.model.tratributkoleksi;
import astratech.dla_api.repository.KoleksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KoleksiService {
    @Autowired
    KoleksiRepository mskoleksiRepository;

    public List<mskoleksi> getAll(){
        List<mskoleksi> dlaMskoleksis = mskoleksiRepository.findAllByBrg_status();
        return dlaMskoleksis;
    }
    public List<mskoleksi> getNewestbyCreadate(){
        List<mskoleksi> dlaMskoleksis = mskoleksiRepository.getNewestbyCreadate();
        return dlaMskoleksis;
    }
    public List<mskoleksi> getNewestbyTahunterbit(){
        List<mskoleksi> dlaMskoleksis = mskoleksiRepository.getNewestbyTahunterbit();
        return dlaMskoleksis;
    }
    public List<mskoleksi> getPopular(){
        List<mskoleksi> dlaMskoleksis = mskoleksiRepository.getPopularBook();
        return dlaMskoleksis;
    }
    public List<Object[]> getDataDashboard(){
        return mskoleksiRepository.getDataDashboard();
    }
    public List<Object[]> getDataDashboardMember(String email){
        return mskoleksiRepository.getDataDashboardMember(email);
    }
    public List<Object[]> getDetailKoleksi(int id){
        return mskoleksiRepository.getDetailKoleksi(id);
    }
    public List<Object[]> getAtributDetail(int id){
        return mskoleksiRepository.getAtributDetail(id);
    }
    public List<Object[]> getKlasifikasiDetail(int id){
        return mskoleksiRepository.getKlasifikasiDetail(id);
    }
}
